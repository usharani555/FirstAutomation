package com.ey.base;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	//properties declaration
	public static Properties conf;
	//properties declaration
	public static Properties or;
	//logger declaration
	public static Logger log;
	public static WebDriver driver;
	
	
	
	//In this method i will intialize all the class level variables
	@BeforeSuite
	public void setup() throws IOException {
		log=Logger.getLogger("project");
		//initializing properties variable
		conf=new Properties();
		
		or=new Properties();
		//create object for the file input stream to read file from config.properties
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\project\\src\\test\\resources\\properties\\config.properties");
		//load the fis file into conf(properties object)
		conf.load(fis);
		log.info("the value in the conf is"+conf.toString());
		//create object for the file input stream to read from from or.properties
		FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\project\\src\\test\\resources\\properties\\or.properties");
		//load the fis1 file into or(properties object) 
		or.load(fis1);
		log.info("the value in the conf is"+or.toString());
		String browser = conf.getProperty("browser");
		if(conf.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("the chrome driver is intialized");	
			
		}
		else if(conf.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.info("the Firefox  driver is intialized");
		}
		else if(conf.getProperty("browser").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			log.info("the Edgedriver  driver is intialized");
			
		}
        String url = conf.getProperty("url");
        log.info("the url is"+url);
       
		driver.get(url);
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(conf.getProperty("implicit_time")), TimeUnit.SECONDS);		
		
	}	
		
	
	@AfterSuite
		public void tearDown() {
		
	}

	}
