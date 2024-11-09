package grid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridExample {

	@Test
	public void test1() throws IOException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName("chrome");

		URL hub = new URL("http://localhost:4444/");
		WebDriver driver = new RemoteWebDriver(hub, cap);

		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// click on the login link
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@12345");

		WebElement rememberMe = driver.findElement(By.id("remember-me"));
		rememberMe.click();

		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
		driver.quit();

	}

}
