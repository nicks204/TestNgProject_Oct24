package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;

public class HomePage {
	
	WebDriver driver = BaseClass.driver;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

}
