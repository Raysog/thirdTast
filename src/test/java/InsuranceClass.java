import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;

/**
 * Created by Ivan on 01.09.2019.
 */
public class InsuranceClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.rgs.ru");
        WebElement strahovanie = driver.findElement(By.xpath("//a[contains(text(), 'Страхование')]"));
        System.out.println(strahovanie.toString());
        strahovanie.click();
        WebElement dms = null;
        dms = strahovanie.findElement(By.xpath("//a[contains(text(), 'ДМС')]"));
        System.out.println(dms.toString());
        dms.click();
        //System.out.println("no such element");
        try {
            WebElement h =  driver.findElement(By.xpath("//h1[contains(text(), 'добровольное медицинское страхование')]"));
            System.out.println(h.getText().toString());
        } catch (NoSuchElementException ex) {
            System.out.println("no such element");
        }

        //driver.close();
    }
}
