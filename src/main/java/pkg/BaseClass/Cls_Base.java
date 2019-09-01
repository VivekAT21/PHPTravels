package pkg.BaseClass;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cls_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	static String nodeURL;
	
	//Create constructor
	public Cls_Base() throws FileNotFoundException {
		
		mtd_configRead();
		String browserName = prop.getProperty("BROWSER");
		if (driver== null) {		
			if (browserName.equalsIgnoreCase("Chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} 
			else if (browserName.equalsIgnoreCase("Headless")) {
				FirefoxBinary fb=new FirefoxBinary();
				fb.addCommandLineOptions("--headless");
				System.setProperty("webdriver.gecko.driver",".\\src\\main\\java\\pkg\\Config\\geckodriver.exe");
				FirefoxOptions foo=new FirefoxOptions();
				foo.setBinary(fb);
				driver=new FirefoxDriver(foo);
			}
			else if (browserName.equalsIgnoreCase("Grid")) {
				nodeURL = "http://10.50.88.59:4444/wd/hub";
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WINDOWS);
				try {
					driver = new RemoteWebDriver(new URL(nodeURL), capability);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
	public void mtd_configRead() throws FileNotFoundException {
		//Load properties
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(".\\src\\main\\java\\pkg\\Config\\config.properties");
			prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	* <h2> geTitle </h2>
	* To get the title of the page
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	public String mtd_getTitle() {
		return driver.getTitle();
	}
	
	public boolean mtd_verifyImage(WebElement element) {
		boolean isVisible =	element.isDisplayed();
		return isVisible;
		}
	/**
	* <h2> geTitle </h2>
	* To click on the element
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	public void mtd_clickLink(WebElement element) {
		element.click();
	}
	/**
	* <h2> getText </h2>
	* To get text of the webelement
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	public String mtd_getText(WebElement element) {
		String getTitle = element.getText();
		return getTitle;
	}
	/**
	* <h2> enterValue </h2>
	* To pass webElement and value as an argument
	* @param   webElement
	* @param   webElement value
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	public void mtd_enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	//if webelement present
	public boolean mtd_wbElement(WebElement element) {
		boolean isPresent = element.isDisplayed();
		return isPresent;
	}
	
	/**
	* <h2> switchtoChild </h2>
	* This function is used to switch between the windows
	* This function is not in use
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	public void mtd_switchtoChild() throws InterruptedException {
		Set<String> driverId=driver.getWindowHandles();
		Iterator<String> it =driverId.iterator();
		String parentId=it.next();
		System.out.println("Parent is " + parentId);
		String childId=it.next();
		System.out.println("Child is " + childId);
		driver.switchTo().window(childId);
	}
	
	/**
	* <h2> ExpectedCondition </h2>
	* This function is used for explict wait for WebElement
	* @param   Webelement (this is pageFactory webelement)
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	//**************************this is customise method for explict wait 	
	public static ExpectedCondition<WebElement> visibilityOfDynamicElementLocated(final WebElement element) {
	    return new ExpectedCondition<WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    try {
	    	return elementIfVisible(element);
	    	} catch (StaleElementReferenceException e) {
	    		return null;
				}
		}

		@Override
		public String toString() {
			return "visibility of element located by " ;
			}
		};
	}
				
	private static WebElement elementIfVisible(WebElement element) {
	    return element.isDisplayed() ? element : null;
	}
		
	/**
	* <h2> explictWait </h2>
	* Explict wait on the basis of pagefactory web element
	* @param   webElement
	* @param   wait time
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	//Function: This is customise menthod for explict wait based on webelements
	//Arguments: Webelement and wait time
	public void mtd_explictWait(WebElement element, int timeSpan) {
		WebDriverWait elementwait = new WebDriverWait(driver, timeSpan);
		elementwait.until(visibilityOfDynamicElementLocated(element));
	}
	
	public void mtd_impl_wait(int waitSec) {
		driver.manage().timeouts().implicitlyWait(waitSec, TimeUnit.SECONDS);
	}
	/**
	* <h2> currntDate </h2>
	* @return  current date and time
	* @author  Vivek Garg
	* @version 1.0
	* @since   2019-05-26 
	*/
	//Function: To get current date and time
	public String mtd_currntDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String curntdate = df.format(date);
		return curntdate;
	}
			
	public static void mtd_selectDate(String day) {
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepicker dropdown-menu'][4]//div[@class='datepicker-days']//tr[5]//td"));
		int count = dates.size();
		System.out.println(count);
		for (int i=0; i<count; i++) {
			String xx= driver.findElements(By.xpath("//div[@class='datepicker dropdown-menu'][4]//div[@class='datepicker-days']//tr[5]//td")).get(i).getText();
			if (xx.equalsIgnoreCase(day)) {
			driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][4]//div[@class='datepicker-days']//tr[5]//td")).click();
			break;
			}
		}
	}
	
	public static void overRiding(int x) {
		System.out.println("I am learning overriding  parent 1: " + x);
	}
	public static void overRiding(String x) {
		System.out.println("I am leardning overloading parent 2: " + x);
	}
	
	public static void overRiding(String x, int y) {
		System.out.println("I am leardning overloading parent 3: " + x);
		System.out.println("I am leardning overloading parent 4: " + y);
	}
}
