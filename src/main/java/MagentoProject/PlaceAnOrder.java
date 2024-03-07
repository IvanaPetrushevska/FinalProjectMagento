package MagentoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceAnOrder {
    private WebDriver driver;
    private WebDriverWait wait;

    public PlaceAnOrder(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String placeOrder() {
        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        return getText("//span[text()=\"Thank you for your purchase!\"]");
    }
    public String logOut(){
        clickOn("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        clickOn("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
        return getText("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    }
    public void clickOn(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }
    public String getText(String elementXpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
    }
}
