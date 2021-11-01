package week4.projects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder=new Actions(driver);
		
		WebElement men = driver.findElement(By.xpath("(//span[@class='catText'])[6]"));
		builder.moveToElement(men).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String count = driver.findElement(By.className("category-count")).getText();
		System.out.println("Count of Sports Shoes :" +count);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		
		Thread.sleep(2000);
		WebElement firstPrice = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]"));
		String firstPP = firstPrice.getText();
		System.out.println("Price of 1st Product :" +firstPP);
		Thread.sleep(2000);
		String replaceAll = firstPP.replaceAll("[\\D]", "");
		int price1 = Integer.parseInt(replaceAll);
		System.out.println(price1);
		
		Thread.sleep(2000);
		WebElement secondPrice = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]"));
		String secondPP = secondPrice.getText();
		System.out.println("Price of 1st Product :" +secondPP);
		Thread.sleep(2000);
		String replaceAll2 = secondPP.replaceAll("[\\D]", "");
		int price2 = Integer.parseInt(replaceAll2);
		System.out.println(price2);
		
		if((price1-price2)<=0) {
			System.out.println("Items are sorted from price low to high");
		}
		else {
			System.out.println("Items are not sorted correctly");
		}
		
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		
		WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromVal.clear();
		Thread.sleep(2000);
		fromVal.sendKeys("575");
		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		Thread.sleep(2000);
		toVal.sendKeys("700");
		driver.findElement(By.xpath("//div[contains(@class, 'price-go-arrow')]")).click();
		Thread.sleep(2000);
		List<WebElement> color = driver.findElements(By.xpath("//p[@class='product-title']"));
			for (WebElement colorCheck : color) {

			  String title = colorCheck.getText();
				if(!title.contains("Navy")) {
				System.out.println("All shoes are not of Color-Navy");
				break;
				}
				
			}
			System.out.println("All shoes are of Color-Navy");
		WebElement title1 = driver.findElement(By.xpath("//p[@title='Columbus Navy Training Shoes']"));
		builder.moveToElement(title1).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		/*
		 * Set<String> winSet = driver.getWindowHandles(); List<String> winList=new
		 * ArrayList<String>(winSet); driver.switchTo().window(winList.get(1));
		 * Thread.sleep(2000);
		 */
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price of Shoe :"+price);
		String percent = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount Percentage :" +percent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();
	}
	
}
