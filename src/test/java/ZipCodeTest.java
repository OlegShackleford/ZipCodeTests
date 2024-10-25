import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    @Test
    public void fourDigitInputTest(){
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.В поле zipcode ввести 1111
        4.Нажать кнопку continue
        5.Проверить появление ошибки
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("1111");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = chromeBrowser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage,"Oops, error on page. ZIP code should have 5 digits");
        chromeBrowser.quit();
        System.out.println("NICE");
    }
}
