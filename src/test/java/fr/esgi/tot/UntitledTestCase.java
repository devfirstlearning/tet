package fr.esgi.tot;


import static org.junit.Assert.fail;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//	  DesiredCapabilities capability = DesiredCapabilities.chrome();
	// say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
//	capability.setCapability("jenkins.label","redhat5 && amd64");
//	// Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
//	capability.setCapability("jenkins.nodeName","(master)");
	  
//	  System.setProperty("webdriver.chrome.driver", "/home/christopher/Téléchargements/chromedriver");
//	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	  capabilities.setVersion("74.0.3729.108");
//	  capabilities.setPlatform(Platform.LINUX);
//	  capabilities.setBrowserName("chrome");
	  
	  
	  
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
      options.addArguments("--headless");
      options.setExperimentalOption("useAutomationExtension", false);
      options.addArguments("start-maximized"); // open Browser in maximized mode
      options.addArguments("disable-infobars"); // disabling infobars
      options.addArguments("--disable-extensions"); // disabling extensions
      options.addArguments("--disable-gpu"); // applicable to windows os only
      options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      options.merge(capabilities);
	  
//	  WebDriver driver = new ChromeDriver(options);
//	  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("--start-maximized");
//	  options.merge(capabilities);
	  

	  
//	  cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);

 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
//    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://www.christopherlukombo.com/");
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Christopher Lukombo'])[1]/following::em[1]")).click();
//    driver.findElement(By.linkText("Portfolio")).click();
//    driver.findElement(By.linkText("A propos")).click();
//    driver.findElement(By.linkText("Accueil")).click();
//    driver.findElement(By.id("bannertext")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Christopher Lukombo'])[1]/following::em[1]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
