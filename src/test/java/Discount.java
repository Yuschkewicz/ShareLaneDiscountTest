import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Discount extends BaseTest {

    @Test
    public void discountShouldBeNull () {


        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String disc = driver.findElement(By.xpath("//tr[2]//td[7]")).getText();
        assertEquals(disc, "100", "price not correct");
// И любой тест на скидку будет аналогичный, и это не учитывая, что скидка суммируется,а не вычитается
    }
}

