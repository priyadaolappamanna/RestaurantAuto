package com.Restaurant.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.Restaurant.Pageobjects.ExpensePage;
import com.Restaurant.Pageobjects.HomePage;
import com.Restaurant.Pageobjects.LogInpage;
import com.Restaurant.Pageobjects.PeopleAddCustomerPage;
import com.Restaurant.Pageobjects.PeopleAddSupplierPage;
import com.Restaurant.Pageobjects.PeopleAddWaiterPage;
import com.Restaurant.Pageobjects.ProductPage;
import com.Restaurant.Pageobjects.ReportsPage;
import com.Restaurant.Pageobjects.SalesPage;
import com.Restaurant.Pageobjects.StoresPage;
import com.Restaurant.Utilities.ExtentReport;
import com.Restaurant.Utilities.RdExl;
import com.Restaurant.action.ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		public static Properties prop;
		//public static WebDriver driver;
		public static ActionClass action;
		public static LogInpage lp;
		public static HomePage hp;
		public static StoresPage sp;
		public static ReportsPage repo;
		public static PeopleAddSupplierPage s1;
		public static PeopleAddCustomerPage c2;
		public static PeopleAddWaiterPage p1;
		public static ProductPage pp;
		public static SalesPage s2;
		public static ExpensePage Ep;
		public static RdExl re;
		//loadConfig method is to load the configuration
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
		@BeforeSuite
		public void BeforeSuite()
		{
			ExtentReport.setExtent();
			DOMConfigurator.configure("log4j.xml");
		}
		@BeforeTest
		
		public void loadConfig() {

			try {
				 prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configurations\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Parameters("Browser")
		@BeforeMethod
		public void firstcall(String browser) {
			launchApp(browser);
			lp=new LogInpage();
			hp=new HomePage();
			sp=new StoresPage();
			repo=new ReportsPage();
			s1=new PeopleAddSupplierPage();
			c2=new PeopleAddCustomerPage();
			p1=new PeopleAddWaiterPage();
			pp=new ProductPage();
			s2=new SalesPage();
			Ep=new ExpensePage();
			re=new RdExl();
		}
		
		public static WebDriver getDriver() {
			return driver.get();
		}
		
		public void launchApp(String browserName) {
			
		  // String browserName = prop.getProperty("Browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				//WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				//driver=new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				//WebDriverManager.firefoxdriver().setup();
				//driver=new FirefoxDriver();
				driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("Edge")) {
				//WebDriverManager.iedriver().setup();
				//driver=new EdgeDriver();
				driver.set(new EdgeDriver());
			}
			//Maximize the screen
			getDriver().manage().window().maximize();
		 action = new ActionClass();
		//	Implicit TimeOuts
		   action.implicitWait(getDriver(), 10);
		//PageLoad TimeOuts
			action.pageLoadTimeOut(getDriver(), 30);   
			getDriver().get(prop.getProperty("url"));
				 
		}
		@DataProvider
		public Object[][] InvalidLoginDatas()
		{
			Object[][] data=new Object[3][2];
			data[0][0]="uname";
			data[0][1]="password";
			data[1][0]="admin";
			data[1][1]="pwrod";
			data[2][0]="login";
			data[2][1]="pasword";
			return data;			
		}
		@AfterMethod
		public void driverclose()
		{
			getDriver().close();	
		}
		@AfterSuite
		public void AfterSuite()
		{
			ExtentReport.endReport();
		}
		
		}

