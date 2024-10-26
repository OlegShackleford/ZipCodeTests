import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ZipCodeTest {

    @Test
    public void fourDigitInputTest() {
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.В поле zipcode ввести 1111
        4.Нажать кнопку continue
        5.Проверить появление ошибки
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("1111");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = chromeBrowser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        chromeBrowser.quit();

    }

    @Test
    public void emptyInputTest() {
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.Поле zipcode оставить пустым
        4.Нажать кнопку continue
        5.Проверить появление ошибки
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = chromeBrowser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        chromeBrowser.quit();

    }

    @Test
    public void lettersInputTest() {
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.В поле zipcode ввести wertre
        4.Нажать кнопку continue
        5.Проверить появление ошибки
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("wertre");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = chromeBrowser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        chromeBrowser.quit();

    }

    @Test
    public void inputSpaceBetweenDigitTest() {
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.В Поле zipcode ввести 123 34
        4.Нажать кнопку continue
        5.Проверить появление ошибки
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("123 34");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = chromeBrowser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        chromeBrowser.quit();

    }


    @Test
    public void validDigitInput() {
        /*
        1.Открыть браузер
        2.Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        3.В поле zipcode ввести 12345
        4.Нажать кнопку continue
        5.Проверить наличие селектора на следующей странице для завершения позитивного теста на ввод валидного zipcode
        6.Закрыть браузер
        */
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://www.sharelane.com/cgi-bin/register.py");
        chromeBrowser.findElement(By.name("zip_code")).sendKeys("12345");
        chromeBrowser.findElement(By.cssSelector("[value = Continue]")).click();
        String soughtElement = chromeBrowser.findElement(By.cssSelector("[class = required_text]")).getText();
        Assert.assertEquals(soughtElement, "*required");
        chromeBrowser.quit();

    }

}
