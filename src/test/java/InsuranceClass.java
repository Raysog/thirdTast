import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

/**
 * Created by Ivan on 01.09.2019.
 */
public class InsuranceClass {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.rgs.ru");
        WebElement strahovanie = driver.findElement(By.xpath("//a[contains(text(), 'Страхование')]"));
        System.out.println(strahovanie.toString());
        strahovanie.click();
        WebElement dms = strahovanie.findElement(By.xpath("//a[contains(text(), 'ДМС')]"));
        System.out.println(dms.toString());
        dms.click();
        //System.out.println("no such element");
        try {
            driver.findElement(By.xpath("//h1[contains(text(), 'добровольное медицинское страхование')]"));
            System.out.println("Заголовок существует");
        } catch (NoSuchElementException ex) {
            System.out.println("Заголовок не найден");
        }
        WebElement buttonOk = driver.findElement(By.xpath("//a[@class=\"btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button\"]"));
        System.out.println(buttonOk.toString());
        buttonOk.click();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
        List<WebElement> form = new ArrayList<WebElement>();
        
        By lastNameLocator = By.xpath("//input[@name=\"LastName\"]");
        WebElement lastName = driver.findElement(lastNameLocator);
        WebDriverWait lastNameWaiter = new WebDriverWait(driver, 5, 1000);
        lastNameWaiter.until(ExpectedConditions.elementToBeClickable(lastNameLocator));
        lastName.sendKeys("Фамилия");
        form.add(lastName);
        System.out.println(lastName.toString());
        
        By firstNameLocator = By.xpath("//input[@name=\"FirstName\"]");
        WebElement firstName = driver.findElement(firstNameLocator);
        WebDriverWait firstNameWaiter = new WebDriverWait(driver, 5, 1000);
        firstNameWaiter.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
        firstName.sendKeys("Имя");
        form.add(firstName);
        System.out.println(firstName.toString());
        
        By middleNameLocator = By.xpath("//input[@name=\"MiddleName\"]");
        WebElement middleName = driver.findElement(middleNameLocator);
        WebDriverWait middleNameWaiter = new WebDriverWait(driver, 5, 1000);
        middleNameWaiter.until(ExpectedConditions.elementToBeClickable(middleNameLocator));
        middleName.sendKeys("Отчетсво");
        form.add(middleName);
        System.out.println(middleName.toString());
        
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByVisibleText("Москва");
        form.add(selectElem);
        System.out.println(selectElem.toString());
        
        
        By phoneLocator = By.xpath("//input[contains(@data-bind,'Phone')]");
        WebElement phone = driver.findElement(phoneLocator);
        WebDriverWait phoneWaiter = new WebDriverWait(driver, 5, 1000);
        phoneWaiter.until(ExpectedConditions.elementToBeClickable(phoneLocator));
        phone.sendKeys("9999876543");
        form.add(phone);
        System.out.println(phone.toString());
        
        
        By eMailLocator = By.xpath("//input[@name=\"Email\"]");
        WebElement eMail = driver.findElement(eMailLocator);
        WebDriverWait eMailWaiter = new WebDriverWait(driver, 5, 1000);
        eMailWaiter.until(ExpectedConditions.elementToBeClickable(eMailLocator));
        eMail.sendKeys("qwertyqwerty");
        form.add(eMail);
        System.out.println(eMail.toString());
        
        
        By commentLocator = By.xpath("//textarea[@name=\"Comment\"]");
        WebElement comment = driver.findElement(commentLocator);
        WebDriverWait commentWaiter = new WebDriverWait(driver, 5, 1000);
        commentWaiter.until(ExpectedConditions.elementToBeClickable(commentLocator));
        comment.sendKeys("testtesttesttest");
        form.add(comment);
        System.out.println(comment.toString());
        
        By checkBoxLocator = By.xpath("//input[@class=\"checkbox\"]");
        WebElement checkBox = driver.findElement(checkBoxLocator);
        checkBox.click();
        form.add(checkBox);
        System.out.println(checkBox.toString());
        
        
        

        //driver.close();
    }
}
