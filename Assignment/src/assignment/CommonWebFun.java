package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class CommonWebFun {	
	
	WebDriverWait wait=new WebDriverWait(InitializeDriver.driver, 20);	 //created reference wait for "WebDriverWait" class and instantiated using "WebDriver" reference
	Logger log = LogManager.getLogger(CommonWebFun.class.getName());
	
	
	/**
	 * launch function: This function is to launch Chrome driver and redirect it to the Base URL
	 * @param URL - Base URL 
	 */	
	public void launch(String URL) {
		InitializeDriver.driver.get(URL);		
		log.info("Launched URL : " + URL);
	}	
	
	/**
	 * verifyTitle function: This function is to assert title of currently opened browser
	 * @param expectedTitle 
	 */	
	public void verifyTitle(String expectedTitle) {			
		Assert.assertEquals(expectedTitle,InitializeDriver.driver.getTitle());
		log.info("Current Title : " + InitializeDriver.driver.getTitle());
	}	
	
	/**
	 * verifyCurrentURL function: This function is to assert Current URL of browser
	 * @param expectedURL 
	 */
	public void verifyCurrentURL(String expectedURL) {			
		Assert.assertEquals(expectedURL,InitializeDriver.driver.getCurrentUrl());
		log.info("Current URL : " + InitializeDriver.driver.getCurrentUrl());
	}
	
	/**
	 * entertext function: This function is to enter text in input fields
	 * @param xpath - xpath of an object where action needs to be performed
	 * @param value - value that needs to be entered in the object
	 */
	public void entertext(String xpath, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));		
		element.sendKeys(value);
		log.info("Entered text : " + value + "on object" + xpath);
	}
	
	/**
	 * click function: This function is to perform click operation on an object
	 * @param xpath - xpath of an object where action needs to be performed
	 */	
	public void click(String xpath) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));		
		element.click();		
		log.info("Clicked on object with xpath of : " + xpath);
	}
	
	/**
	 * closeDriver function: This function is to close the instance of driver
	 * @param null
	 */	
	public void closeDriver() {
		InitializeDriver.driver.close();
		log.info("Closed the driver ");
	}
	
	/**
	 * getText function: This function is to retrieve text of an object
	 * @param xpath - xpath of an object where action needs to be performed
	 */	
	public String getText(String xpath) {		
		return InitializeDriver.driver.findElement(By.xpath(xpath)).getText();
	}
	
	/**
	 * isDisplayed function: This function is to verify if given object is displayed or not
	 * @param xpath - xpath of an object where action needs to be performed
	 */		
	public void isDisplayed(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		boolean elementPresence=element.isDisplayed();
		log.info("Object is displayed for an xpath : " + xpath + " is ----- " + elementPresence);
	}
	
	/**
	 * selectJobSector function: This function is to validate job sector functionality
	 * @param xpath - xpath of an object where action needs to be performed
	 * @param sectoroption - preference of jobs sector
	 */	
	public void selectJobSector(String xpath,String sectoroption) {
		String sectorXpath, jobsLinkXpath, applyButton, homeTabXpath = "";
		jobsLinkXpath = "(//ul[@class='lister cf block']/li/div/h3/a)[1]";
		applyButton = "(//a[text()=' Apply '])[1]";
		homeTabXpath ="//a[text()='Home']";
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	
        List<WebElement> jobsbysector =InitializeDriver.driver.findElements(By.xpath(xpath));
        for(WebElement webele : jobsbysector){        	
            if(webele.getText().contains(sectoroption)){
            	log.info("Selected sector is : " + webele.getText());
            	webele.click();
            	sectorXpath = "//h1[contains(text(),'param_sectorname')]".replace("param_sectorname", sectoroption);
            	isDisplayed(sectorXpath);
            	click(jobsLinkXpath);
            	isDisplayed(applyButton);
            	log.info(" ***************************************** ");
        		log.info(" Successfully validated - "+ sectoroption + " jobs sector page and job details page " );
        		log.info(" ***************************************** ");
        		click(homeTabXpath);
            	break;
            }
        }        
    }
	
	/**
	 * selectFromDropDown function: This function is to select values from dropdown using by values
	 * @param xpath - xpath of an object where action needs to be performed
	 * @param miles - values that needs to be selected from dropdown
	 */	
	
	public void selectFromDropDown(String xpath, String miles) {
		Select dropdown = new Select(InitializeDriver.driver.findElement(By.xpath(xpath)));  
		dropdown.selectByValue(miles);  
	}   

		
	
}
