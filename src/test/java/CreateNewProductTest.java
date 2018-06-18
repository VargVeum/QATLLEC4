import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.LoginPage;
import pages.Product;
import pages.ShopPage;

public class CreateNewProductTest extends BaseTest {

  @DataProvider
  public Object[] getCredentials() {
    return new Object[]{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"};
  }

  @Test(dataProvider = "getCredentials")
  public void addNewProductAndCheck(String login, String password){
    LoginPage loginPage = new LoginPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);
    ShopPage shopPage = new ShopPage(driver);

    loginPage.openAdminURL();
    // Part A. Actions with admin panel
    loginPage.enterLogin(login);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();
    // Add new product
    catalogPage.clickProductButton();
    catalogPage.clickNewProductButton();

    Product product = new Product();
    catalogPage.enterProductName(product.getName());
    catalogPage.enterProductQuantity(product.getQuantity());
    catalogPage.enterProductPrice(product.getPrice());
    catalogPage.clickSwitchToggle();
    catalogPage.clickSaveNewProductButton();
    // Logout from admin panel
    loginPage.clickToHeaderMenu();
    loginPage.clickToLogoutButton();
    // Part B. Action with shop
    loginPage.openShopURL();
    shopPage.goToAllProducts();
    shopPage.openMyTestProduct();
    Assert.assertEquals(shopPage.getProductName(), product.getName(), "Product name isn't as expected");
    Assert.assertEquals(shopPage.getProductQuantity(), product.getQuantity(), "Quantity isn't as expected");
    Assert.assertEquals(shopPage.getProductPrice(), product.getPrice(), "Price isn't as expected");
    // close driver
    closeChromeDriver();



  }
}
