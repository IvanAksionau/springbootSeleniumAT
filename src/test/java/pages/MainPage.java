package pages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "env", havingValue = "qa")
public class MainPage {

  @Autowired
  private LoginPage loginPage;
  @Autowired
  private HomePage homePage;
  @Value("${app.url}")
  private String appUrl;

  public MainPage() {
    System.out.println("In Main Page");
  }

//    public MainPage(LoginPage loginPage, HomePage homePage) {
//        this.loginPage = loginPage;
//        this.homePage = homePage;
//    }

  public void PerformLogin() {

    System.out.println("Login:" + appUrl);
    homePage.clickLogin();
    loginPage.Login("admin", "adminpassword23432");
    loginPage.ClickLogin();
  }
}
