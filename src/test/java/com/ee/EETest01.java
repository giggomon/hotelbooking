package com.ee;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class EETest01 {
	
	static WebDriver driver;
	static Select dropdown;
	static WebElement fromDateBox, toDateBox;
	
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver_win32_v76\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://hotel-test.equalexperts.io/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void addABooking() throws Exception {		
		//beforeClass();
		//declare an implicit wait for sync
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Booking 1
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("mw First One");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("mw Last One");
		driver.findElement(By.cssSelector("input[id='totalprice']")).sendKeys("1000");
		
		dropdown = new Select(driver.findElement(By.id("depositpaid")));
		dropdown.selectByVisibleText("false");
		
		 //Click Checkin Date and Wait until checkin calendar visible
		WebElement fromDateBox= driver.findElement(By.id("checkin"));
		fromDateBox.clear();
		fromDateBox.click();
		fromDateBox.sendKeys("2019-11-03"); //Enter date in required format
		Thread.sleep(2000);
	    
		WebElement toDateBox= driver.findElement(By.id("checkout"));
		toDateBox.clear();
		toDateBox.click();
		toDateBox.sendKeys("2019-12-05"); //Enter date in required format
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]"))).click();
		//driver.findElement(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]")).click();
		Thread.sleep(3000);
		
		//Booking 2
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("mw First Two");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("mw Last Two");
		driver.findElement(By.cssSelector("input[id='totalprice']")).sendKeys("2000");
		
		dropdown.selectByVisibleText("true");
		
		 //Click Checkin Date and Wait until checkin calendar visible
		fromDateBox.clear();
		fromDateBox.click();
		fromDateBox.sendKeys("2019-02-01"); //Enter date in required format
		Thread.sleep(2000);
		
		toDateBox.clear();
		toDateBox.click();
		toDateBox.sendKeys("2019-05-05"); //Enter date in required format
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]"))).click();
		Thread.sleep(3000);
		
		//Booking 3
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("mw First Three");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("mw Last Three");
		driver.findElement(By.cssSelector("input[id='totalprice']")).sendKeys("3000");
		
		dropdown.selectByVisibleText("true");
		
		 //Click Checkin Date and Wait until checkin calendar visible
		fromDateBox.clear();
		fromDateBox.click();
		fromDateBox.sendKeys("2019-02-01"); //Enter date in required format
		Thread.sleep(2000);
		
		toDateBox.clear();
		toDateBox.click();
		toDateBox.sendKeys("2019-05-05"); //Enter date in required format
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]"))).click();
		Thread.sleep(3000);
		
		//Booking 4
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("mw First Four");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("mw Last Four");
		driver.findElement(By.cssSelector("input[id='totalprice']")).sendKeys("4000");
		
		dropdown.selectByVisibleText("true");
		
		 //Click Checkin Date and Wait until checkin calendar visible
		fromDateBox.clear();
		fromDateBox.click();
		fromDateBox.sendKeys("2019-02-01"); //Enter date in required format
		Thread.sleep(2000);
		
		toDateBox.clear();
		toDateBox.click();
		toDateBox.sendKeys("2019-05-05"); //Enter date in required format
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]"))).click();
		Thread.sleep(3000);
		
		//Booking 5
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("mw First Five");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("mw Last Five");
		driver.findElement(By.cssSelector("input[id='totalprice']")).sendKeys("5000");
		
		dropdown.selectByVisibleText("true");
		
		 //Click Checkin Date and Wait until checkin calendar visible
		fromDateBox.clear();
		fromDateBox.click();
		fromDateBox.sendKeys("2019-05-05"); //Enter date in required format
		Thread.sleep(2000);
		
		toDateBox.clear();
		toDateBox.click();
		toDateBox.sendKeys("2019-10-05"); //Enter date in required format
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div:nth-child(7) > input[type=button]"))).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

	
	@Test
	public void removeABooking() throws Exception {
		beforeClass();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement bookingsElements = driver.findElement(By.id("bookings"));
		List<WebElement> allDivElements = bookingsElements.findElements(By.tagName("div"));
		List<String> idList = new ArrayList<String>();
		
	    for (WebElement e : allDivElements) {
    	
	        if(!e.getAttribute("id").isEmpty()) {
	            String s = e.getAttribute("id");
	            idList.add(s);
	        }
	    }
	        for(String id : idList) {
	            //  //*[@id="175918"]/div[1]/p (FirstName Xpath)
	            // //*[@id="175918"]/div[7]/input (Delete Button Xpath)
	        	String deleteFirstNameXPath = "//*[@id=\"" + id + "\"]/div[1]/p";
	        	String deleteButtonXPath = "//*[@id=\"" + id + "\"]/div[7]/input";

	        	WebElement removeFirstName = driver.findElement(By.xpath(deleteFirstNameXPath));

	            if (removeFirstName.getText().contains("mw")){
	            	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteButtonXPath))); 	            	
	            	driver.findElement(By.xpath(deleteButtonXPath)).click(); 
	                }
		    }
	
    Thread.sleep(3000);
	}
	
    @AfterClass
    public void afterClass() {
          driver.quit();
    }

}
