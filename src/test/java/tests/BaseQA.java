package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.TextBoxPage;
import utils.QAProps;

public class BaseQA {//<listeners class-name="utils.ListenerTestNG"></listeners> in testng before test
    WebDriver driver;
    TextBoxPage textBoxPage;
    String url;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        url= QAProps.getValue("url");
      textBoxPage = new TextBoxPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
