import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondTest {
	private WebDriver driver = null;
	
		@Before
	    public void startValues() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }
		
		@Test
		public void secondTest() {
			driver.navigate().to("http://www.sberbank.ru/ru/person");
			WebElement button = driver.findElement(By.xpath("//span[ancestor::div[contains(@class, 'paste-region__region header__region header__region_')]]"));
			button.click();
			WebElement findCity = driver.findElement(By.xpath("//input[@class=\"kit-input__control\"][@type=\"search\"]"));
			findCity.sendKeys("Нижегородская область\n");
			WebElement city = driver.findElement(By.xpath("//div[@class=\"hd-ft-region__title\"]/span"));
			assertEquals("Регион указан неправильно", "Нижегородская область", city.getText());
			WebElement footer = driver.findElement(By.xpath("//footer"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
			assertEquals("Присутствуют не все значки соц. сетей", 6, driver.findElements (By.xpath("//span[contains(@class,'footer__social_logo footer__social_')]")).size());
		}
		
		@After
	    public void stopTest() throws Exception {
	        //driver.quit();
	    }
}
