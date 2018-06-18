package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage  {
  private final WebDriver driver;

  public CatalogPage(WebDriver driver) {
    this.driver = driver;
  }

  public void clickProductButton() {
    WebElement productButton = driver.findElement(By.cssSelector("li[data-submenu='10']"));
    productButton.click();
  }

  public void clickNewProductButton(){
    WebElement productButton = driver.findElement(By.id("page-header-desc-configuration-add"));
    productButton.click();
  }

  public void enterProductName(String name){
    WebElement productName = driver.findElement(By.id("form_step1_name"));
    productName.sendKeys(name);
  }

  public void enterProductQuantity(int quantity){
    WebElement productQuantity = driver.findElement(By.id("form_step1_qty_0_shortcut"));
    productQuantity.sendKeys(Integer.toString(quantity));
  }

  public void enterProductPrice(double price){
    WebElement productPrice = driver.findElement(By.id("form_step1_price_shortcut"));
    productPrice.sendKeys(Double.toString(price));
  }

  public void clickSwitchToggle(){
    WebElement statusToggle = driver.findElement(By.id("form_step1_active"));
    statusToggle.click();
  }

  public void clickSaveNewProductButton(){
    WebElement saveProductButton = driver.findElement(By.cssSelector("button[class='btn btn-primary js-btn-save']"));
    saveProductButton.click();
  }






}
