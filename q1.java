package cc1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;  

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class q1
{
    public static void main( String[] args ) throws InterruptedException
    {
      WebDriverManager.edgedriver().setup();
      WebDriver driver = new EdgeDriver();
      
      String url=" https://www.saucedemo.com/";
     
      //Launching the url
      driver.get(url);
      //maximize the window screen
      JavascriptExecutor js =  (JavascriptExecutor) driver;
      
      driver.manage().window().maximize();
//      Navigating down
      
//      find the first name
      driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
      //find the last name
      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
       //find the email and send email
      driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
      Thread.sleep(7000);
      driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
      driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
      
      
      driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form")).isDisplayed();
      
      driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("kishore");
      driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("CM");
      driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("641011");
      driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
      

      String product=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
      String price =driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).getText();
      System.out.println("Product Name: " + product);
      System.out.println("Product Price : " + price);
      driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
      
      
      String title = driver.getTitle();
      Assert.assertEquals(title, "Swag Labs");
      if(title.equals("Swag Labs"))
    	  System.out.println("Title is corrrect");
      String url1 = driver.getCurrentUrl();
      Assert.assertEquals(url1, "https://www.saucedemo.com/checkout-step-two.html");
      if(url1.equals("https://www.saucedemo.com/checkout-step-two.html"))
    	  System.out.println("url is corrrect");
      
     
    }
}