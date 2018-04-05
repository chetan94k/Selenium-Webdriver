package WebTesting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.google.common.io.Files;

public class ScreenshotOnException {
    
	  static WebDriver driver;
	  static EventFiringWebDriver eventDriver;
	
	//method to take screenshot
	public void takeScreenshot() throws IOException
	{
		 File src=((TakesScreenshot)eventDriver).getScreenshotAs(OutputType.FILE);
		 Files.copy(src,new File("C://Screenshots//A1.png"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.gecko.driver","C://geckodriver-v0.18.0-win32//geckodriver.exe");
	         
		WebDriver driver=new FirefoxDriver();
		eventDriver=	new EventFiringWebDriver(driver); 
		ExceptionListener listener=new ExceptionListener();
		eventDriver.register(listener);
		   
        //accessing the URL
	      eventDriver.get("https://www.ksrtc.in");
	     
	    //accessing the incorrect xpath to get  "No such Element Exception"
	     WebElement textbox=eventDriver.findElement(By.xpath("//*[@id='froPlaceName']"));
	}

}
