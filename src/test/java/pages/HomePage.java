package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

  @FindBy(linkText = "Login")
  public WebElement loginLink;
  @FindBy(linkText = "Employee List")
  public WebElement employeeListLink;

  public void clickLogin() {
    loginLink.click();
  }

  public void clickEmployeeList() {
    employeeListLink.click();
  }
}
