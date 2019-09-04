import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ivan on 01.09.2019.
 */
public class firstTest {
    /**
     * @param args
     */
	private WebDriver driver = null;
	private Map<WebElement, String> enterValues = null;
	
		@Before
	    public void startValues() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        driver = new ChromeDriver();
	        enterValues = new HashMap<WebElement, String>();
	    }
	
	 	@Test
	    public void formTest(){
	        driver.navigate().to("http://www.rgs.ru");
	        
	        WebElement strahovanie = driver.findElement(By.xpath("//a[contains(text(), 'Страхование')]"));
	        strahovanie.click();
	        
	        WebElement dms = strahovanie.findElement(By.xpath("//a[contains(text(), 'ДМС')]"));
	        dms.click();
	        
	        try {
	            driver.findElement(By.xpath("//h1[contains(text(), 'добровольное медицинское страхование')]"));
	            System.out.println("Заголовок существует");
	        } catch (NoSuchElementException ex) {
	            System.out.println("Заголовок не найден");
	        }
	        
	        WebElement buttonOk = driver.findElement(By.xpath("//a[@class=\"btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button\"]"));
	        buttonOk.click();
	        
	        addText("//input[@name=\"LastName\"]", "Фамилия");
	        addText("//input[@name=\"FirstName\"]", "Имя");
	        addText("//input[@name=\"MiddleName\"]", "Отчетсво");
	        addSelect("Москва", "77");  
	        addPhone("//input[contains(@data-bind,'Phone')]", "(999) 987-65-43");      
	        addText("//input[@name=\"Email\"]", "qwertyqwerty");
	        addText("//textarea[@name=\"Comment\"]", "testtesttesttest");
	        addCheckBox("//input[@class=\"checkbox\"]", "on");
	        
	        
	        for (WebElement webElement : enterValues.keySet()) {
	        	assertEquals("value of element \""+ webElement.getAttribute("name") + "\" is false",enterValues.get(webElement) , webElement.getAttribute("value")); 
	    	}
	        
	        By buttonLocator = By.xpath("//button[@id=\"button-m\"]");
	        WebElement button = driver.findElement(buttonLocator);
	        button.click();
	        assertEquals("У Поля Эл. почта не присутствует сообщение об ошибке Введите корректный email", 
	        			 "Введите адрес электронной почты",  
	        			 driver.findElement(By.xpath("//span[@class=\"validation-error-text\"]")).getAttribute("innerText"));
	 	}
	 	
	 	@After
	    public void stopTest() throws Exception {
	        driver.quit();
	    }
    
    private void addText(String xpath, String value) {
    	By commentLocator = By.xpath(xpath);
        WebElement comment = driver.findElement(commentLocator);
        WebDriverWait commentWaiter = new WebDriverWait(driver, 5, 1000);
        commentWaiter.until(ExpectedConditions.elementToBeClickable(commentLocator));
        String commentValue = value;
        comment.sendKeys(commentValue);
        enterValues.put(comment, commentValue);
    }
    
    private void addPhone(String xpath, String value) {
    	By phoneLocator = By.xpath(xpath);
        WebElement phone = driver.findElement(phoneLocator);
        WebDriverWait phoneWaiter = new WebDriverWait(driver, 5, 1000);
        phoneWaiter.until(ExpectedConditions.elementToBeClickable(phoneLocator));
        String phoneValue = value;
        phone.sendKeys(phoneValue);
        enterValues.put(phone, "+7 " + phoneValue);
    }
    
    private void addSelect(String textValue, String idValue) {
    	WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        String selectValue = textValue;
        select.selectByVisibleText(selectValue);
        enterValues.put(selectElem, idValue);
    }
    
    private void addCheckBox(String xpath, String value) {
    	By checkBoxLocator = By.xpath(xpath);
        WebElement checkBox = driver.findElement(checkBoxLocator);
        checkBox.click();
        String checkBoxValue = value;
        enterValues.put(checkBox, checkBoxValue);
    }
}
