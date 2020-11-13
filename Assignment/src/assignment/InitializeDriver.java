package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver {
	
	static WebDriver driver = null;
	
	public static void initDriver() {
		// declaration and instantiation of chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Selenium Jars\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

}
