package com.ea.springbasic.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Component
public class ScreenShotUtil {

    @Autowired
    protected WebDriver webDriver;

    @Value("${screenshot.path}")
    private Path screenshotPath;

    public void takeScreenShot() {
        File screenshot = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(
                    screenshotPath.toString()  + "\\" + UUID.randomUUID() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Take screenshot");
    }
}
