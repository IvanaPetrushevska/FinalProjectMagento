package MagentoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddToCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String listNewItems(){
        clickOn("//*[@id=\"ui-id-3\"]/span");
        return getText("//*[@id=\"page-title-heading\"]/span");
    }
    public String viewYogaItems(){
        clickOn("//*[@id=\"maincontent\"]/div[4]/div[1]/div[2]/div[1]/a/span/span[2]");
        return getText("//*[@id=\"page-title-heading\"]/span");
    }
    public String addToWishlist(){
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/strong/a");
        clickOn("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]/span");
        return getText("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");
    }
    public String moveItemFromWishlistToCart(){
        clickOn("//*[@id=\"wishlist-sidebar\"]/li/div/div/div[2]/div[1]/button/span");
        clickOn("//*[@id=\"option-label-size-143-item-171\"]");
        clickOn("//*[@id=\"option-label-color-93-item-49\"]");
        clickOn("//*[@id=\"product-addtocart-button\"]");
        return getText("//*[@id=\"wishlist-view-form\"]/div[1]/span");
    }

    public String addSecondItemToCart() {
        clickOn("//*[@id=\"ui-id-4\"]/span[2]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
        selectItemByVisibleText("//*[@id=\"sorter\"]", "Price");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/strong/a");
        clickOn("//*[@id=\"option-label-size-143-item-167\"]");
        clickOn("//*[@id=\"option-label-color-93-item-56\"]");
        clickOn("//*[@id=\"product-addtocart-button\"]/span");
        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    }
    public String searchForRunningShorts(){
        typeIn("//*[@id=\"search\"]", "running shorts");
        clickOn("//*[@id=\"search_mini_form\"]/div[2]/button");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span");
    }

    public String addThirdItemToCart() {
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/dl/dd[3]/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[1]/div/div/strong/a");
        clickOn("//*[@id=\"option-label-size-143-item-173\"]");
        clickOn("//*[@id=\"option-label-color-93-item-60\"]");
        clickOn("//*[@id=\"product-addtocart-button\"]/span");
        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"); //
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
