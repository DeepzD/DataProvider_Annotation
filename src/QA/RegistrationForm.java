package QA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationForm {
WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Deepika\\Selenium\\chromedriver_win32_100\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@Test(dataProvider="getData")
	public void fillForm(String firstName, String lastName, String Email, String MobileNo, String year, int month, String Subject,
						String profilePic, String currentAddress )
	{
	//Enter Values to the fields
			//:: Name Fields
			driver.findElement(By.id("firstName")).sendKeys(firstName);
			driver.findElement(By.id("lastName")).sendKeys(lastName);
			
			//::Email Field
			driver.findElement(By.id("userEmail")).sendKeys(Email);
			
			//::Gender Radio Button
			driver.findElement(By.xpath("//label[text()='Female']")).click();
			
			//::Mobile Field
			driver.findElement(By.id("userNumber")).sendKeys(MobileNo);
			
			//:: Date of Birth Field
			driver.findElement(By.id("dateOfBirthInput")).clear();
			// 1 - Select Year
			WebElement ddl_year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
			Select selectYear=new Select(ddl_year);
			selectYear.selectByValue(year);
			
			// 2 - Select Month
			WebElement ddl_month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
			Select selectMonth=new Select(ddl_month);
			selectMonth.selectByIndex(month);
			
			// 3 - Select Date
			driver.findElement(By.xpath("//div[@class='react-datepicker__week'][2]/div[1]")).click();
			
			// :: Subjects Field
			driver.findElement(By.id("subjectsInput")).sendKeys(Subject);
			
			// :: Hobbies Field
			WebElement chkbox_Reading= driver.findElement(By.xpath("//label[text()='Reading']"));
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", chkbox_Reading);
			
			// :: Picture Upload Field
			driver.findElement(By.id("uploadPicture")).sendKeys(profilePic);
			
			// :: Current Address Field
			driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
	
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] s_data=new Object[2][9];
		
		// :: 1st set
		s_data[0][0]="Deepika";
		s_data[0][1]="Damayanthi";
		s_data[0][2]="Deepika.Damayanthi@gmail.com";
		s_data[0][3]="0112345678";
		s_data[0][4]="1990";
		s_data[0][5]=8;
		s_data[0][6]="IT";
		s_data[0][7]="C:\\Users\\User\\Desktop\\Deepika\\Selenium\\Selenium_Project\\StudentRegistration\\src\\ProfilePicture\\ProfilePic.png";
		s_data[0][8]="Colombo-2";
		
		// :: 2nd set
		s_data[1][0]="Deepika";
		s_data[1][1]="Padukone";
		s_data[1][2]="Deepika.Padukone@gmail.com";
		s_data[1][3]="0112345679";
		s_data[1][4]="1992";
		s_data[1][5]=6;
		s_data[1][6]="Finance";
		s_data[1][7]="C:\\Users\\User\\Desktop\\Deepika\\Selenium\\Selenium_Project\\StudentRegistration\\src\\ProfilePicture\\ProfilePic.png";
		s_data[1][8]="Colombo-3";
		
		return s_data;
	}
	
}
