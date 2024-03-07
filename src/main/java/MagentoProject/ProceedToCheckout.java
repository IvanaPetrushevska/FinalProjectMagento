package MagentoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProceedToCheckout {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProceedToCheckout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String checkout() {
        clickOn("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button/span");
        return getText("//*[@id=\"shipping\"]/div[1]");
    }
    public String enterShippingDetails(){
        typeIn("//*[@id=\"shipping-new-address-form\"]/div[3]/div/input", "Company");
        typeIn("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div/div/input", "Street");
        typeIn("//*[@id=\"shipping-new-address-form\"]/div[4]/div/input","City");
        selectItemByVisibleText("//*[@id=\"shipping-new-address-form\"]/div[5]/div/select","Alabama");
        typeIn("//*[@id=\"shipping-new-address-form\"]/div[7]/div/input","22584");
        typeIn("//*[@id=\"shipping-new-address-form\"]/div[9]/div/input", "264589752");
        clickOn("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input");
        clickOn("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
        return getText("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    }
    public void typeIn(String elementXpath, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).sendKeys(text);
    }

    public void clickOn(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }

    public String getText(String elementXpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
    }
    public void selectItemByVisibleText(String elementXpath, String visibleText) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)))).selectByVisibleText(visibleText);
    }
}
