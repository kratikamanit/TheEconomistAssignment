package assignment;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DriverScript {

	public static void main(String[] args) {
		InitializeDriver.initDriver();
		CommonWebFun cwf = new CommonWebFun();
		ObjectExtraction po = new ObjectExtraction();
		ScenariosFunc sf = new ScenariosFunc();
		
		Logger log = LogManager.getLogger(DriverScript.class.getName());	// logger allows to report error, warning and info messages 	
		BasicConfigurator.configure();
				
		String baseURL = "https://jobs.economist.com/";		
		cwf.launch(baseURL); // launch Chrome and redirect it to the Base URL
		
//		TC_1 : pageLoadVerification function validates the below scenarios
//		- Jobs page renders correctly with the following components visible:
//		    - navigation bar
//		    - search fields
//		    - sector lists
//		    - jobs blog
//		    - featured jobs
//		    - footer
		sf.pageLoadVerification();
		
//		TC_2 : validateSignInCreateAccount function validates 
//		Both 'Sign in' and 'Create account' links go to their respective pages.
		sf.validateSignInCreateAccount();
		
//		TC_3 : navBarValidation function validates
//		Each of the links in the navigation bar is functional and goes to the correct page
		sf.navBarValidation();
		
//		TC_4 : jobsBySectorValidation function validates
//		Clicking on a sector shows a list of jobs from only that sector. 
//		Clicking further on a job listing shows you the job details, with an 'apply' button
		sf.jobsBySectorValidation();
		
//		TC_5 : jobSearchValidation function validates
//		Searching for a job correctly displays relevant search results 
		sf.jobSearchValidation("Director", "INDIA", "0");
		
//		TC_6 : footerlinksValidation function validates
//		Ensuring all the links in the footer are functional
		sf.footerlinksValidation();
		
//		TC_7 : validateCreateAccount function validates
//		Account Creation Functionality
		sf.validateCreateAccount("Test", "User", "test12345user@abc.com", "test1234");
		
//		TC_8 : validateSignIn function validates
//		Sign In Functionality
		sf.validateSignIn("test12345user@abc.com", "test1234");
			
		
		cwf.closeDriver(); // Close Chrome Driver
	}
}
