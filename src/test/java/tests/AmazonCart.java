package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cart;

import java.util.List;

public class AmazonCart{

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void aLogin() {
        driver.get("https://www.amazon.in/");
        Cart login = new Cart(driver);
        login.getSignIn().click();
        login.getMobNumber().sendKeys("8296269156");
        login.getSubmitNum().click();
        login.getPassword().sendKeys("8296269156");
        login.getSubmitPass().click();
        String hello = login.getRetrieveText().getText();
        Assert.assertEquals(hello,"Hello, Ayesha");
    }

    @Test
    public void bSearchProduct() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        Cart searchProduct = new Cart(driver);
      WebElement element= searchProduct.getSearchBox();
      element.sendKeys("Lipstick");
      element.sendKeys(Keys.ENTER);
      String text = searchProduct.getRetrieveProduct().getText();
    Assert.assertEquals(text,"\"Lipstick\"");
    }
    @Test
    public void cSelectQuantity() throws InterruptedException {
        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?keywords=Lipstick&qid=1676020300&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart selectQuantity = new Cart(driver);
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOf(selectQuantity.getDropDown()));
        Select dropDown = new Select(selectQuantity.getDropDown());
        dropDown.selectByIndex(2);
        Assert.assertEquals(3,3);

    }
        @Test
        public void dAddCart() throws InterruptedException {
        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?crid=39IW83DQBSANF&keywords=lipstick&qid=1676112264&sprefix=%2Caps%2C391&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart addCart=new Cart(driver);
        addCart.getAddToCartButton().click();
        String text=addCart.CartText.getText();
        Assert.assertEquals(text,"Added to Cart");

    }
    @Test
    public void eInStock() throws InterruptedException {

        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?keywords=Lipstick&qid=1676020300&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart InStock = new Cart(driver);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(InStock.getInStockText()));
        String text = InStock.getInStockText().getText();
        Assert.assertEquals(text,"In stock");

    }
    @Test
    public void fReviews() throws InterruptedException {
        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?crid=39IW83DQBSANF&keywords=lipstick&qid=1676112264&sprefix=%2Caps%2C391&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart review = new Cart(driver);
        review.getReviewLink().click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(review.getReviewImage()));
        review.getReviewImage().click();
        String text =review.getReviewText().getText();
        Assert.assertEquals(text,"Reviews with images");

    }

    @Test
    public void gDeliveryCharges() {
        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?crid=39IW83DQBSANF&keywords=lipstick&qid=1676112264&sprefix=%2Caps%2C391&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart delivery=new Cart(driver);
        String text =delivery.getDeliveryCharge().getText();
        Assert.assertEquals(text,"FREE delivery");
    }

    @Test
    public void hSelectAddress(){
        driver.get("https://www.amazon.in/RENEE-FAB5-FAB-Lipstick-7-5g/dp/B08HRZ9QPH/ref=sr_1_1_sspa?crid=39IW83DQBSANF&keywords=lipstick&qid=1676112264&sprefix=%2Caps%2C391&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
        Cart address=new Cart(driver);
        address.getAddressLink().click();
        String text = address.getAddressText().getText();
        Assert.assertEquals(text,"Choose your location");

    }
    @Test
    public void iCheckCart(){
        driver.get("https://www.amazon.in/");
        Cart checkCart = new Cart(driver);
        checkCart.getSignIn1().click();
        checkCart.getMobNumber1().sendKeys("8296269156");
        checkCart.getSubmitNum1().click();
        checkCart.getPassword1().sendKeys("8296269156");
        checkCart.getSubmitPass1().click();
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        String text = checkCart.getCartText().getText();
        System.out.println(text);
        Assert.assertEquals(text,"Shopping Cart");

    }
    @Test
    public void NegativeLogin()  {
        driver.get("https://www.amazon.in/");
        Cart login = new Cart(driver);
        login.getSignIn().click();
        login.getMobNumber().sendKeys("82962656");
        login.getSubmitNum().click();
        String text=login.getErrorText() .getText();
        Assert.assertEquals(text,"Incorrect phone number");
    }

        @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
