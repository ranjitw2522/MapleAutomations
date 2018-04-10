package loginfuctions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
//Hello New Push

public class NewTest 
{
	WebDriver driver=null;
  @Test(priority=1)
  public void Title() 
  {
	  String expected="http://packagingsnehdeep.com/";
	  String actual=driver.getCurrentUrl();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=2,dependsOnMethods="Title")
  public void Contact()
  {
	  
	 WebElement ele= driver.findElement(By.xpath("//*[text()='CONTACT']"));
	 if(ele.isDisplayed())
	 {
		 if(ele.isEnabled())
		 {
			 ele.click();
		 }
		 else
		 {
			 System.out.println("Contact button is not enabled");
		 }
	 }
	 else
	 {
		 System.out.println("contact button is not displayed");
	 }
	  String expected="http://packagingsnehdeep.com/contact.html";
	  String actual=driver.getCurrentUrl();
	  Assert.assertEquals(actual, expected);
	  
  }
  @Test(priority=3,dependsOnMethods="Contact")
  public void enterData() throws InterruptedException
  {
	  driver.findElement(By.xpath("//input[@class='form-control'][@name='name']")).sendKeys("Ranjit");
	  driver.findElement(By.xpath("//input[@class='form-control'][@name='email']")).sendKeys("Ranjitw2522@gmail.com");
	  driver.findElement(By.xpath("//input[@class='form-control'][@name='phone']")).sendKeys("8796969393");
	  driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Mention Specific Quantity");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  String Expected="Contactus";
	  String Actual=driver.getTitle();
	  Assert.assertEquals(Actual, Expected);
  }
  
  
  @BeforeTest
  public void beforeTest() 
  {
	driver=new FirefoxDriver();
	driver.get("http://packagingsnehdeep.com"); 
	driver.manage().window().maximize();
  }
  
  

  /*@AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
*/
}
