package pages;
import java.util.Random;

public class Product {
  private double price;
  private int quantity;
  private String name;

  public Product(){
      Random random = new Random();
      price = random.nextDouble()*100 + 1;
      quantity = random.nextInt(100)+1;
      name = "Product_" + random.nextInt(100000);
  }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

}






