package DW;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DW002 {
	AndroidDriver driver;
	@Test
	public void LogIn() {

		driver.findElement(MobileBy.xpath("//input[@name=\"Email\"]")).sendKeys("manzoorrocks191@gmail.com");
		driver.findElement(MobileBy.xpath("//input[@name=\"Password\"]")).sendKeys("manipal");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.hideKeyboard();
		driver.findElement(MobileBy.xpath("//input[@value='Log in']")).sendKeys(Keys.ENTER);
		String ExpectedText="manzoorrocks191@gmail.com";
		String ActualText=driver.findElement(MobileBy.linkText("manzoorrocks191@gmail.com")).getText();
		Assert.assertEquals(ExpectedText, ActualText);	

	}
	@Test
	public void LogOut()
	{
		driver.findElement(MobileBy.xpath("//a[text()='Log out']")).click();
		String ExpectedText="Log in";
		String ActualText=driver.findElement(MobileBy.xpath("//a[text()='Log in']")).getText();
		Assert.assertEquals(ExpectedText, ActualText);
	}
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability("deviceName","Ankur");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://demowebshop.tricentis.com/login");
	}

	@AfterClass
	public void afterClass() {
			
		driver.close();
	}

}
