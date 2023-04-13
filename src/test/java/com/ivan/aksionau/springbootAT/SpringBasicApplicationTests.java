package com.ivan.aksionau.springbootAT;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import pages.MainPage;

@SpringBootTest
@Profile("qa")
class SpringBasicApplicationTests {

  @Autowired
  private MainPage mainPage;

  @Value("${app.url}")
  private String appUrl;

  @Value("chrome,firefox,edge")
  private List<String> browsers;

  @Test
  void contextLoads() {

    System.out.println(appUrl);

    //method reference
    browsers.forEach(System.out::println);

//		HomePage homePage = new HomePage();
//		LoginPage loginPage = new LoginPage();
//		LoginPage loginPage = page.ClickLogin();
//		loginPage.ClickLogin();

    //MainPage mainPage = new MainPage(loginPage, homePage);
    mainPage.PerformLogin();
  }

}
