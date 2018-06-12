package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.Food;
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

/*

    double randomPrice = price.nextInt(100) + 1;
    // random quantity
    Random quantity = new Random();
    int productQuantity = quantity.nextInt(100) + 1;
    // faker randomizer for product name
    Faker faker = new Faker();
    Food randomFoodProduct = faker.food();*/

}






