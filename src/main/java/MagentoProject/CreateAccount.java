package MagentoProject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private Faker faker;

    public CreateAccount(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.faker = new Faker();
    }
    public String createAnAccount() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        clickOn("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", email);
        typeIn("//*[@id=\"password\"]", "Password123");
        typeIn("//*[@id=\"password-confirmation\"]", "Password123");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button/span");

        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    }
    public String paymentMethod(){
        clickOn("//ul/li[8]/a[contains(text(),'Stored Payment Methods')]");
        return getText("//*[text()='You have no stored payment methods.']");
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
}

