package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    // WebElement element = driver.findElement(By.xpath("//input[@id=\"j_idt88:name\"]"))
    WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id=\"j_idt88:name\"]")
    public WebElement typeTextBox;

    @FindBy(xpath = "//input[@id=\"j_idt88:j_idt91\"]")
    public WebElement appendCountryTextBox;

    @FindBy(xpath = "//input[@id=\"j_idt88:j_idt93\"]")
    public WebElement disabledTextBox;

    @FindBy(xpath = "//input[@id=\"j_idt88:j_idt97\"]")
    public WebElement clearTextBox;

    @FindBy(xpath = "//input[@id=\"j_idt88:j_idt95\"]")
    public WebElement retrieveTextBox;


    public WebElement getTypeTextBox() {
        return typeTextBox;
    }

    public WebElement getAppendCountryTextBox() {
        return appendCountryTextBox;
    }

    public WebElement getDisabledTextBox() {
        return disabledTextBox;
    }

    public WebElement getClearTextBox() {
        return clearTextBox;
    }

    public WebElement getRetrieveTextBox() {
        return retrieveTextBox;
    }

}