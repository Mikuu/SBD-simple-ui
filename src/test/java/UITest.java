import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class UITest {
    private String chromeDriverProperty = "webdriver.chrome.driver";
    private String chromeDriverExcutable = "/Users/ariman/Software/selenium/chromedriver/chromedriver";

    private String ticketsTab = "#indexLeftBR > div.slideTxtBox > div.hd > ul > li.on";
    private String ticketsIframe = "#indexLeftBR > div.slideTxtBox > div.tempWrap > div > ul:nth-child(1) > li > iframe";
    private String departTitle = "#board_table > tbody > tr:nth-child(1) > th:nth-child(1)";

    @Test
    public void BasicTest() throws Exception {
        System.setProperty(chromeDriverProperty, chromeDriverExcutable);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081");

        WebElement element = driver.findElement(By.cssSelector(ticketsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);

        WebElement iframe = driver.findElement(By.cssSelector(ticketsIframe));
        driver.switchTo().frame(iframe);

        element = driver.findElement(By.cssSelector(departTitle));
        assertEquals(element.getText(), "出发地");

        driver.quit();
    }

}
