import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");
        driver.findElement(By.name("first_name")).sendKeys("MisterPipkin");
        driver.findElement(By.name("email")).sendKeys("11@ert.nz");
        driver.findElement(By.name("password1")).sendKeys("qwerty");
        driver.findElement(By.name("password2")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String mail = driver.findElement(By.xpath("//*[contains(text(), 'Email')]/..//b")).getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td/p/a")).click();
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login")).click();
        driver.get("https://sharelane.com/cgi-bin/show_book.py?book_id=2");
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");}


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

