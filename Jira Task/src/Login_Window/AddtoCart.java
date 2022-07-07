package Login_Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import Search.search_type;


public class AddtoCart extends search_type  {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, Exception {

		System.setProperty("webdriver.chrome.driver", "F:\\Automation Libraries\\Selenium\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		// options.addArguments("incongnito");
		WebDriver driver = new ChromeDriver();
//				
		driver.manage().window().maximize();

		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(6000);

		String path = "C:\\Users\\Tinkesh Rane\\Desktop\\Password.xlsx";

		FileInputStream file = new FileInputStream(path);

		Workbook book = WorkbookFactory.create(file);

		String uname = book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(uname);

		String pass = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();

		System.out.println(pass);

		WebElement uname1 = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));

		uname1.sendKeys(uname);

		WebElement pass1 = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));

		pass1.sendKeys(pass);
		file.close();

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

		Thread.sleep(8500);

		Actions act = new Actions(driver);

		WebElement profilename = driver.findElement(By.xpath("//div[@class='exehdJ']"));
		act.moveToElement(profilename).perform();

		WebElement myprofile = driver.findElement(By.xpath("//div[text()='My Profile']"));
		act.moveToElement(myprofile).perform();

		// WebElement sidehover =
		// driver.findElement(By.xpath("//div[@class='_1TmfNK']"));
		// act.moveToElement(sidehover).perform();

		String profile = profilename.getText();

		if (profile.equalsIgnoreCase("Tinkesh")) {
			System.out.println("Account logged in");

			act.moveToElement(driver.findElement(By.xpath("//div[@class='_1TmfNK']"))).perform();
			
			Thread.sleep(2000);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss a");
			LocalDateTime now = LocalDateTime.now();
			String s = dtf.format(now);

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\Tinkesh Rane\\Pictures\\Whatsapp imges\\scshot" + s + ".jpeg");
			FileHandler.copy(source, dest);
		}
		else
		{
			System.out.println("Account not logged in");
		}

		WebElement cartno = driver.findElement(By.xpath("//a[@class='_3SkBxJ']"));
		String cartitem = cartno.getText();

		System.out.println("Total no of product in cart is " + cartitem);

		if (cartitem.equalsIgnoreCase("cart")) 
		{
			System.out.println("cart is empty");

			search_type.use(driver);
			
			WebElement price_details = driver.findElement(By.xpath("//div[@class='_I_XQO']"));
			String pdetails = price_details.getText();
			System.out.println(pdetails);

			Thread.sleep(2000);
			System.out.println("screen shot taken");
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss a");
			LocalDateTime now1 = LocalDateTime.now();
			String ss = dtf1.format(now1);

			File source1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest1 = new File("C:\\Users\\Tinkesh Rane\\Pictures\\Whatsapp imges\\scshot" + ss + ".jpeg");
			FileHandler.copy(source1, dest1);

			Thread.sleep(1500);
			//driver.quit();

		} 
		else 
		{

			driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();

			Thread.sleep(10000);

			WebElement price_details = driver.findElement(By.xpath("//div[@class='_I_XQO']"));
			String pdetails = price_details.getText();
			System.out.println(pdetails);

			Thread.sleep(2000);
			System.out.println("screen shot taken");

			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss a");
			LocalDateTime now1 = LocalDateTime.now();
			String ss = dtf1.format(now1);

			File source1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest1 = new File("C:\\Users\\Tinkesh Rane\\Pictures\\Whatsapp imges\\scshot" + ss + ".jpeg");
			FileHandler.copy(source1, dest1);

			WebElement placebtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']"));
			WebElement cont = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']"));

				if (placebtn.getText().equalsIgnoreCase("Place Order"))

				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);",placebtn);
					js.executeScript("window.scrollBy(0,2000)");

					Thread.sleep(2500);
					driver.findElement(By.xpath("(//div[@class='_3dsJAO'])[2]")).click();
				}
				else if (cont.getText().equalsIgnoreCase("CONTINUE"))
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					// js.executeScript("arguments[0].scrollIntoView(true);",cont);
					js.executeScript("window.scrollBy(0,2000)"); // Scroll Down

					Thread.sleep(2500);
					driver.findElement(By.xpath("(//div[@class='_3dsJAO'])[2]")).click();
				}

				Thread.sleep(2000);

				driver.findElement(By.xpath("//div[@class='_3dsJAO _24d-qY FhkMJZ']")).click();
				Thread.sleep(2000);

				WebElement empty = driver.findElement(By.xpath("//div[@class='_1LCJ1U']"));

				if (empty.getText().equalsIgnoreCase("Your cart is empty!"))
					{
						System.out.println("Cart is Empty");
					}

				driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 13 pro max" + Keys.ENTER);
				Thread.sleep(3500);

				WebElement pb = driver.findElement(By.xpath("(//img[@class='_396cs4 _3exPp9'])[1]"));
				pb.click();

				ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(add.get(1)); // switch to next tab

				Thread.sleep(4500);

				WebElement load = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));

				Thread.sleep(2500);

				load.click();

				Thread.sleep(5500);

				WebElement price_details1 = driver.findElement(By.xpath("//div[@class='_I_XQO']"));
				String pdetails1 = price_details1.getText();
				System.out.println(pdetails1);

				Thread.sleep(2000);
				System.out.println("screen shot taken");
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss a");
				LocalDateTime now2 = LocalDateTime.now();
				String ss1 = dtf2.format(now2);
	
				File source2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File dest2 = new File("C:\\Users\\Tinkesh Rane\\Pictures\\Whatsapp imges\\scshot" + ss1 + ".jpeg");
				FileHandler.copy(source2, dest2);
	
				// SIGNOUT
	
				Thread.sleep(2000);
				Actions bct = new Actions(driver);
				WebElement Tinkesh = driver.findElement(By.xpath("//div[text()='Tinkesh']"));
				bct.moveToElement(Tinkesh).perform();
	
				Thread.sleep(2000);
	
				WebElement signout = driver.findElement(By.xpath("(//div[@class='_3vhnxf'])[10]"));
				bct.moveToElement(signout).perform();
				bct.click().perform();
				Thread.sleep(5000);
//																			driver.findElement(By.xpath("(//ul[@class='pO9syL undefined']//li//descendant::a[@class='_2kxeIr'])[10]")).click();

			// QUIT BROWSER

				//driver.quit();

		}
	}
}
