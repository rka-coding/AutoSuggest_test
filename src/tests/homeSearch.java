package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class homeSearch 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String URL = "https://amazon.com";
	
	 @BeforeTest
	 public void setUp(){
	 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("webdriver.gecko.driver",
			  "/Users/karth/Documents/Softwares/chromedriver.exe"); 
	 }
	@Test(priority =0)
	public void autoSuggestclick() {
	
	 driver.navigate().to(URL);
	    SoftAssert soft = new SoftAssert();
		int count = 0,expectedCount = 11;
		int indexToSelect = 0;
		driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("ch");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("s-suggestion"), 0));
		List<WebElement> autoSuggestions = driver.findElements(By.className("s-suggestion"));
		autoSuggestions.forEach(suggestion -> System.out.println(suggestion.getAttribute("innerText")));
	    count = autoSuggestions.size();
		 System.out.println(" Total number of suggested list is "  +count);
		 soft.assertEquals(expectedCount,count);
			 
	 if(indexToSelect<= count) {
		 System.out.println("Trying to select based on index: "+indexToSelect);
		 autoSuggestions.get(indexToSelect).click(); 
		 
	   }
	
				
		
              } 
	@Test(priority =1)

	public void validateOpenLink()
	{
		String  expectedTitle = "Amazon.com: chromecast";
		String actualTitle = driver.getTitle();
		
	//	System.out.println("Expected" +expectedTitle);
	//	System.out.println("Actual" +actualTitle);
		assertEquals(expectedTitle,actualTitle);
		
	}
	
	 @AfterTest()
	 
	 public void tearDown() {
		 driver.quit();
	 }
	 
		
	
	
	}


	
	


