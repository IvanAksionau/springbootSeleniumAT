package com.ea.springbasic.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Lazy
@Component
public class AdbSMSReader implements SMSReader {

    private final static String QUERY_URI_CONTENT_SMS_INBOX
            = "adb shell content query --uri content://sms/inbox";
    private final static String SENDER_NUMBER = "NOTICE";

    @Override
    public String extractVerificationCode() {
        int millis = 15000;
        log.info("Wait " + (millis/1000) +" seconds to get SMS verification code");
        String line = "";
        try {
            Thread.sleep(millis);
            log.info("Extracting verification code from SMS");
            Process process = Runtime.getRuntime().exec(QUERY_URI_CONTENT_SMS_INBOX);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((line = reader.readLine()) != null) {
                if (line.contains("address=" + SENDER_NUMBER)) {
                    return extractBodyValue(line);
                }
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            log.error("Error while extracting verification code from SMS", e);
        }
        return line;
    }

    private String extractBodyValue(String input) {
        String[] tokens = input.split(", ");
        for (String token : tokens) {
            if (token.startsWith("body=")) {
                return token.substring("body=".length())
                        .replaceAll("\\D", "");
            }
        }
        return null;
    }
}
