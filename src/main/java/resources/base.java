package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	  public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
 FileInputStream fis = new FileInputStream(
		 System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");


prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	String path = System.getProperty("user.dir") + "\\driver\\geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", path);
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
	String path = System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe";
	System.setProperty("webdriver.ie.driver", path);
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}


}
