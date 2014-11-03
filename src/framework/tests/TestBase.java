package framework.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import framework.factories.DataFactory;
import framework.factories.PageFactory;



public abstract class TestBase {
	protected WebDriver driver;
	protected PageFactory pageFactory;
	protected DataFactory dataFactory;


//	@BeforeTest
//	public void setUp()  {
	
//	
//	}
	
	@BeforeClass
	public void createVariables(){
		driver = new FirefoxDriver();
		pageFactory = new PageFactory(driver);
		dataFactory = new DataFactory();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.petsmart.com");
		
	
	}
		
	@AfterTest
	public void driverQuit() throws Exception{
		driver.quit();
		
	}



}
