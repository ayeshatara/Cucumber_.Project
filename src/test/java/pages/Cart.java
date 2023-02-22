package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    //login
    @FindBy(xpath = "//div[@id=\"nav-tools\"]//a[3]")
    public WebElement SignIn;
    @FindBy(xpath ="//input[@type=\"email\"]" )
    public WebElement MobNumber;
    @FindBy(xpath ="//input[@id=\"continue\"]" )
    public WebElement SubmitNum;
    @FindBy(xpath ="//input[@type=\"password\"]" )
    public WebElement Password;
    @FindBy(xpath ="//input[@id=\"signInSubmit\"]" )//"//span[@id=\"nav-link-accountList-nav-line-1\"]"
    public WebElement SubmitPass;
    @FindBy(xpath = "//span[@id=\"nav-link-accountList-nav-line-1\"]")
    public WebElement RetrieveText ;
    @FindBy(xpath = "//h4[@class=\"a-alert-heading\"]")
    public WebElement ErrorText;

    public WebElement getSignIn() {
        return SignIn;
    }

    public WebElement getMobNumber() {
        return MobNumber;
    }

    public WebElement getSubmitNum() {
        return SubmitNum;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getSubmitPass() {
        return SubmitPass;
    }

    public WebElement getRetrieveText() {
        return RetrieveText;
    }

//searchProduct
    @FindBy(id = "twotabsearchtextbox")
    public  WebElement SearchBox;
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement RetrieveProduct;

    public WebElement getSearchBox() {
        return SearchBox;
    }

    public WebElement getRetrieveProduct() {
        return RetrieveProduct;
    }
    public WebElement getErrorText() {
        return ErrorText;
    }



    //selectQuantity
    @FindBy(xpath = "//select[@name=\"quantity\"]")
    public WebElement DropDown;
    public WebElement getDropDown() {
        return DropDown;
    }



    //addCart
    @FindBy(id="add-to-cart-button")
    public WebElement addToCartButton;
    @FindBy(xpath = "//div[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]//span")
    public WebElement CartText;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public WebElement getCartText() {
        return CartText;
    }


    //InStock
    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-success\"]")
    public WebElement InStockText;
    public WebElement getInStockText() {
        return InStockText;
    }

    //Reviews
    @FindBy(xpath = "//a[@id=\"acrCustomerReviewLink\"]")
    public WebElement ReviewLink;
    @FindBy(xpath = "//div[@class=\"review-with-images-section\"]//span[1]//img")
    public WebElement ReviewImage;
    @FindBy(xpath = "//div[@id=\"reviews-image-gallery-container\"]//h3")
    public WebElement ReviewText;

    public WebElement getReviewLink() {
        return ReviewLink;
    }
    public WebElement getReviewImage() {
        return ReviewImage;
    }
    public WebElement getReviewText() {
        return ReviewText;
    }



    //Delivery Charge
    @FindBy(xpath = "//a[@href=\"/gp/help/customer/display.html?nodeId=200904360\"]")
    public WebElement DeliveryCharge;
    public WebElement getDeliveryCharge() {
        return DeliveryCharge;
    }
    //Address
    @FindBy(xpath = "//div[@id=\"contextualIngressPtLabel_deliveryShortLine\"]")
    public WebElement AddressLink;
    @FindBy(xpath = "//h4[@class=\"a-popover-header-content\"]")
    public WebElement AddressText;

    public WebElement getAddressLink() {
        return AddressLink;
    }
    public WebElement getAddressText() {
        return AddressText;
    }
//CheckCart
    @FindBy(xpath = "//div[@id=\"nav-tools\"]//a[3]")
    public WebElement SignIn1;
    @FindBy(xpath ="//input[@type=\"email\"]" )
    public WebElement MobNumber1;
    @FindBy(xpath ="//input[@id=\"continue\"]" )
    public WebElement SubmitNum1;
    @FindBy(xpath ="//input[@type=\"password\"]" )
    public WebElement Password1;
    @FindBy(xpath ="//input[@id=\"signInSubmit\"]" )//"//span[@id=\"nav-link-accountList-nav-line-1\"]"
    public WebElement SubmitPass1;
    @FindBy(xpath = "//span[@id=\"nav-link-accountList-nav-line-1\"]")
    public WebElement RetrieveText1 ;
    @FindBy(xpath = "//div[@id=\"sc-active-cart\"]//h1)")
    public WebElement ShoppingCartText;

    public WebElement getSignIn1() {
        return SignIn1;
    }

    public WebElement getMobNumber1() {
        return MobNumber1;
    }

    public WebElement getSubmitNum1() {
        return SubmitNum1;
    }

    public WebElement getPassword1() {
        return Password1;
    }

    public WebElement getSubmitPass1() {
        return SubmitPass1;
    }

    public WebElement getRetrieveText1() {
        return RetrieveText1;
    }

    public WebElement getShoppingCartText() {
        return ShoppingCartText;
    }

}

