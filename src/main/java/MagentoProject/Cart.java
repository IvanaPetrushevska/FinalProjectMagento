package MagentoProject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;

    public Cart (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String viewCart() {
        clickOn("/html/body/div[2]/header/div[2]/div[1]/a/span[2]");
        clickOn("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span");
        return getText("//*[@id=\"cart-totals\"]/div/table/tbody/tr[3]/td/strong/span");
    }
    public String removeItemFromCart(){
        By removeItemLocator = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[2]/td/div/a[3]/span");
        scrollIntoView(removeItemLocator);
        WebElement removeItemButton = driver.findElement(removeItemLocator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeItemButton);
        } catch (ElementClickInterceptedException e) {
        }
        return getText("//*[@id=\"cart-totals\"]/div/table/tbody/tr[2]/td/strong/span");
    }
    private void scrollIntoView(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickOn(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }

    public String getText(String elementXpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
    }
}
