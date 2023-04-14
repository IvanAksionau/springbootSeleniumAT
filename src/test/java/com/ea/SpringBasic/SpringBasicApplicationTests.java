package com.ea.SpringBasic;

import com.ea.SpringBasic.pages.MainPage;
import com.ea.SpringBasic.pages.MainPage2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
/*
  set 'spring.profiles.active=qa' in VM options/env variables of run configuration
 */
class SpringBasicApplicationTests {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private MainPage2 mainPage2;

    /**
     * Value injection
     */
    @Value("${app.url}")
    private String appUrl;
    @Value("chrome,firefox,edge")
    private List<String> browsers;
    @Value("${app.users}")
    private List<String> users;

    @Test
    void contextLoads() {
        System.out.println(appUrl);
        mainPage.PerformLogin();
        mainPage2.PerformLogin();
    }
}
