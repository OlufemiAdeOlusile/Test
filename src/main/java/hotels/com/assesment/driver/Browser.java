package hotels.com.assesment.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public interface Browser {

    WebDriver getDriver();

    void setWebDriver(WebDriver driver);

    WebElement getAllElement(String key);

    void waitHTMLCSS (String key);

    void waitHTMLClass(String key);

    void mySendkeys(String input, String key);

    void waitHTMLLinkedText(String key);

    void waitSeconds(Integer seconds);

    void waitBy(By by);

    void waitHTMLID(String key);
}
