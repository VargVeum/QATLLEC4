package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class LoginPage{
  private WebDriver driver;

  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  public void waitForElementsCount(By locator, int count) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
  }


    public void openAdminURL() {
    driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
  }

  public void openShopURL(){
    driver.get("http://prestashop-automation.qatestlab.com.ua/");
  }

  public void clickToLogoutButton() {
    WebElement logoutButton = driver.findElement(By.id("header_logout"));
    logoutButton.click();
  }

  public void clickToHeaderMenu() {
    WebElement userMenu = driver.findElement(By.id("header_employee_box"));
    userMenu.click();
  }

  public void clickLoginButton() {
    WebElement loginButton = driver.findElement(By.name("submitLogin"));
    loginButton.click();
  }

  public void enterPassword(String password) {
    WebElement passwordField = driver.findElement(By.id("passwd"));
    passwordField.sendKeys(password);
  }

  public void enterLogin(String login) {
    WebElement loginField = driver.findElement(By.id("email"));
    loginField.sendKeys(login);
  }

}
