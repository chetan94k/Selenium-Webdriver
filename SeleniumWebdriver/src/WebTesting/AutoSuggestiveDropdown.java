package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub

       System.setProperty("webdriver.gecko.driver","C://geckodriver-v0.18.0-win32//geckodriver.exe");
       WebDriver  driver=new FirefoxDriver();
       
       //accessing the URL
       driver.get("https://www.ksrtc.in");
       WebElement textbox=driver.findElement(By.xpath("//*[@id='fromPlaceName']"));
       
       //passing the text in the textbox to bring out the auto suggestive dropdown
       textbox.sendKeys("BENG");
       
       //wait is added for auto suggestive dropdown to show up
       Thread.sleep(2000);
       
       //Javascript executor is used to access hidden elements
       String script="return document.getElementById(\"fromPlaceName\").value;";
       JavascriptExecutor js=(JavascriptExecutor)driver;
       String text=(String)js.executeScript(script);
       int i=0;
       
       //To print the auto suggestive drop down values
       while(!text.equalsIgnoreCase("BENGALURU AIRPORT"))
       {
    	   i++;
    	   textbox.sendKeys(Keys.DOWN);
    	    text=(String)js.executeScript(script);
            System.out.println(text);       
            if(i>10)
            {
            	System.out.println("Element not Found");
            	break;
            }
       }
       }

}
