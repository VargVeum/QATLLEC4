package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShopPage {
  private final WebDriver driver;

  public ShopPage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToAllProducts(){
    WebElement allProductsButton = driver.findElement(By.cssSelector("a[class='all-product-link pull-xs-left pull-md-right h4']"));
    allProductsButton.click();
  }

  public void openMyTestProduct(){
    // переделать селектор для поиска элемента + Добавить проверки, что название продукта, цена и количество соответствует значениям,
    // которые вводились при создании продукта в первой части сценария.
    WebElement searchMyProduct = (WebElement) driver.findElements(By.cssSelector("h1[class='h3 product-title']"));
    searchMyProduct.click();


    searchMyProduct.click();

  }

}