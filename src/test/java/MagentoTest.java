import MagentoProject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MagentoTest {
    private Browser browser;
    private WebDriver driver;
    private WebDriverWait wait;
    private CreateAccount account;
    private AddToCart addToCart;
    private Cart cart;
    private ProceedToCheckout checkoutForm;
    private PlaceAnOrder order;

    @BeforeClass
    public void setup() {
        browser = new Browser();
        driver = browser.getDriver();
        wait = browser.getWait();
        browser.openWebsite("https://magento.softwaretestingboard.com/");
        account = new CreateAccount(driver, wait);
        addToCart = new AddToCart(driver, wait);
        cart = new Cart(driver, wait);
        checkoutForm = new ProceedToCheckout(driver, wait);
        order = new PlaceAnOrder(driver, wait);
    }

    @Test(priority = 1)
    public void testForVerifyingUserIsLandingOnHomepage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/");
    }

    @Test(priority = 2)
    public void testForVerifyingAccountIsSuccessfullyCreated() {
        Assert.assertEquals(account.createAnAccount(), "Thank you for registering with Main Website Store.");
    }
    @Test(priority = 3)
    public void testForPaymentMethod(){
        Assert.assertEquals(account.paymentMethod(),"You have no stored payment methods.");
    }
    @Test(priority = 4)
    public void testForWhatsNew(){
        Assert.assertEquals(addToCart.listNewItems(),"What's New");
    }
    @Test(priority = 5)
    public void testForViewingYogaProducts(){
        Assert.assertEquals(addToCart.viewYogaItems(),"New Luma Yoga Collection");
    }
    @Test(priority = 6)
    public void testForSuccessfullyAddingItemToWishList(){
        Assert.assertEquals(addToCart.addToWishlist(),"My Wish List");
    }
    @Test(priority = 7)
    public void testForMovingItemFromWishlistToCart(){
        Assert.assertEquals(addToCart.moveItemFromWishlistToCart(),"You have no items in your wish list.");
    }

    @Test(priority = 8)
    public void testForAddingTheSecondItemToCart() {
        Assert.assertEquals(addToCart.addSecondItemToCart(), "You added Radiant Tee to your shopping cart.");
    }
    @Test(priority = 9)
    public void testForSearchingForProduct(){
        Assert.assertEquals(addToCart.searchForRunningShorts(),"Search results for: 'running shorts'");

    }

    @Test(priority = 10)
    public void testForAddingTheThirdItemToCart() {
        Assert.assertEquals(addToCart.addThirdItemToCart(), "You added Maxima Drawstring Short to your shopping cart.");
    }

    @Test(priority = 11)
    public void testForViewingPriceInCart() {
        Assert.assertEquals(cart.viewCart(), "$74.00");
    }
    @Test(priority = 12)
    public void testForRemovingItemFromCart(){
        Assert.assertEquals(cart.removeItemFromCart(),"$50.00");
    }
    @Test(priority = 13)
    public void testForProceedingToCheckout() {
        Assert.assertEquals(checkoutForm.checkout(), "Shipping Address");
    }
    @Test(priority = 14)
    public void testForShippingDetails(){
        Assert.assertEquals(checkoutForm.enterShippingDetails(), "Payment Method");
    }

    @Test(priority = 15)
    public void testForSuccessfulOrder() {
        Assert.assertEquals(order.placeOrder(), "Thank you for your purchase!");
    }
    @Test(priority = 16)
    public void testForSuccessfullSignOut(){
        Assert.assertEquals(order.logOut(),"Sign In");
    }
    @AfterClass
    public void teardown() {
        browser.closeBrowser();
    }
}
