package com.ea.springbasic.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ScreenShotUtil {

    @Autowired
    protected WebDriver webDriver;

    @Value("${screenshot.path}")
    private Path screenshotPath;

    public void takeScreenShot(String prefix) {
        String fileName =
                prefix.isEmpty() ? UUID.randomUUID() + ".png" : prefix + UUID.randomUUID() + ".png";
        File screenshot = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath.toString() + "\\" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Take screenshot");
    }
}
