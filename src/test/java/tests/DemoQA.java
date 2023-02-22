package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.*;
import pages.TextBoxPage;
import utils.ListenerTestNG;
import utils.QAProps;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

//@Listeners(ListenerTestNG.class)
public class DemoQA extends BaseQA {

    @DataProvider
    public Object[][] dataprovider(){
        return  new Object[][]{
                {"user1","pass1"},
                {"user2","pass2"},
                {"username","password"},
        };
    }
@Test(dataProvider = "dataprovider")
public void login(String username,String password){
    System.out.println(username);
    System.out.println(password);

}
   @Test
    public  void testCase1()  {
                                                            //TESTCASE STEPS
       driver.get("https://www.amazon.in/");                //open browser Nd navigate to amazon.in
       By by = By.id("twotabsearchtextbox");               //Enter mobiles in search bar
        WebElement element=driver.findElement(by);         //click search or ENTER key
        element.sendKeys("mobiles");          //mobiles should displayed
        element.sendKeys(Keys.ENTER);

        String text = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"))
                .getText();

       Assert.assertEquals(text,"\"mobiles\"");

        /* if(text.equals("\"mobiles\""))
            System.out.println("mobiles are displayed");
        else
            System.out.println("mobiles are not displayed");*/

    }

    @Test
    public void textBox(){
        driver.get(url);


      // WebElement element=driver.findElement(By.xpath("//input[@id=\"j_idt88:name\"]")).sendkeys("Ayesha);
        TextBoxPage textBoxPage = new TextBoxPage(driver);
             textBoxPage.getTypeTextBox().sendKeys("Ayesha");

     //  driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt91\"]")).sendKeys(" India");
        textBoxPage.getAppendCountryTextBox().sendKeys("India");

       String disabled = textBoxPage.getDisabledTextBox().getAttribute("disabled");
       Assert.assertEquals(disabled,"true");

       // driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt95\"]")).clear();
        textBoxPage.getClearTextBox().click();

       String value = textBoxPage.getRetrieveTextBox().getAttribute("value");
       Assert.assertEquals(value,"Can you clear me, please?");

    }

    @Test
    public void button(){
        driver.get("https://leafground.com/button.xhtml;jsessionid=node01e3jtk1wiumwy1hlor79fdvomt79919.node0");
        driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt90\"]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://leafground.com/dashboard.xhtml"));
        driver.get("https://leafground.com/button.xhtml;jsessionid=node01e3jtk1wiumwy1hlor79fdvomt79919.node0");


        String disabled=driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt92\"]"))
              .getAttribute("disabled");
        Assert.assertEquals(disabled,"true");


       Point point =  driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt94\"]"))
                .getLocation();
        Assert.assertEquals(point.getX(),81);
        Assert.assertEquals(point.getY(),397);

        Dimension dimension = driver.findElement(By.xpath("//button[@name=\"j_idt88:j_idt98\"]"))
                .getSize();
        Assert.assertEquals(dimension.getWidth(),86);
        Assert.assertEquals(dimension.getHeight(),33);


         List<WebElement> buttons = driver
                .findElements(By.xpath("(//div[@class=\"card\"])[7]/button"));
        Assert.assertEquals(buttons.size(),4);

    }

    @Test
    public void dropDown() throws InterruptedException{
        driver.get("https://leafground.com/select.xhtml");
        Select dropDown = new
                Select(driver.findElement(By.xpath("//select[@class=\"ui-selectonemenu\"]")));
        dropDown.selectByIndex(1);
        dropDown.selectByVisibleText("Playwright");

        driver.findElement(By.xpath("//div[@id=\"j_idt87:country\"]")).click();
                                                    //tagname[@attribite='value']
        driver.findElement(By.xpath("//li[text()='India']")).click();
                                                    //tagname[text()="value"]
        Thread.sleep(2000);

    driver.findElement(By.id("j_idt87:city")).click();

    Thread.sleep(2000);

    List<WebElement> cities = driver.findElements(By.xpath("ul[@id=\"j_idt87:city_input\"]"));
    List<String> citiesString = Arrays.asList("Bengaluru","Chennai","Delhi");
    for (int i=1; i<= cities.size();i++){
        Assert.assertEquals(cities.get(i).getText(), citiesString.get(i-1));
    }

    }

    @Test
    public void checkBox() throws InterruptedException{
        driver.get("https://leafground.com/checkbox.xhtml;jsessionid=node0aesuuvvx7cossi9pjsiowfvk82778.node0");
        driver.findElement(By.xpath("//span[@class=\"ui-chkbox-label\"]")).click();
      Boolean b =  driver.findElement(By.xpath("//span[@class=\"ui-chkbox-label\"]")).isSelected();


    driver.findElement(By.xpath("//div[@id=\"j_idt87:j_idt91\"]//div[2]")).click();
  // String info= driver.findElement(By.xpath("//span[@clas=\"ui-growl-title\"]")).getText();
  //  Assert.assertEquals(info,"Checked");
    driver.findElement(By.xpath("//div[@id=\"j_idt87:j_idt91\"]//div[2]")).click();
       //  info= driver.findElement(By.xpath("//span[@clas=\"ui-growl-title\"]")).getText();
       // Assert.assertEquals(info,"Unchecked");

        //toggle
     driver.findElement(By.xpath("//div[@class=\"ui-toggleswitch-slider\"]")).click();

     //disable CheckBox
   String disabled = driver.findElement(By.xpath("//input[@id=\"j_idt87:j_idt102_input\"]"))
             .getAttribute("disabled");
   Assert.assertEquals(disabled,"true");

   //multiple checkbox
     /*   driver.findElement(By.id("j_idt87:multiple")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("j_idt87:multiple:0")).click(); */


    }


    @Test
    public void hyperLink(){
        driver.get("https://leafground.com/link.xhtml;jsessionid=node01r6cfhdz9p9x51wkrce3xhxl4u85757.node0");
       driver.findElement
               (By.xpath("//div[@class=\"grid ui-fluid\"]//div[1]//div[3]//a")).click();
     // Assert.assertTrue(driver.getCurrentUrl().contains("https://leafground.com/dashboard.xhtml"));


    }

    @Test
    public void waitsTest() throws InterruptedException {
        driver.get("https://leafground.com/waits.xhtml");
        driver.findElement(By.xpath("//button[@id=\"j_idt87:j_idt89\"]")).click();
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.id("j_idt87:show"))));

        driver.findElement(By.id("j_idt87:show")).click();


    }

    @Test
    public void Tables(){
        driver.get("https://leafground.com/table.xhtml;jsessionid=node01q23e7ap4qlq0312y9ixvg37987032.node0");
      WebElement table =  driver.findElement(By.xpath("(//table[@role=\"grid\"])[2]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(int i=0;i< rows.size();i++){
            WebElement row = rows.get(i);
            List<WebElement> column = row.findElements(By.tagName("td"));

            for(int j=0;j<column.size();j++){
                System.out.println(column.get(j).getText());
            }
        }

    }

    @Test
    public void fileTest() throws InterruptedException {
        driver.get("https://leafground.com/file.xhtml;jsessionid=node01q23e7ap4qlq0312y9ixvg37987032.node0");
      //  driver.findElement(By.id("j_idt88:j_idt89_input")).sendKeys("C:/Users/AYTARANN/Pictures/Screenshots/Screenshot(1).png");
        Thread.sleep(2000);
        File beforeDownloads = new File("C:\\Users\\AYTARANN\\Downloads");
       int i = beforeDownloads.listFiles().length+1;

        driver.findElement(By.id("j_idt93:j_idt95")).click();

        Thread.sleep(5000);
        File afterDownloads = new File("C:\\Users\\AYTARANN\\Downloads");
      int j=  afterDownloads.listFiles().length;
        Assert.assertEquals(beforeDownloads.listFiles().length+1,afterDownloads.listFiles().length);

    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://leafground.com/alert.xhtml");
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("j_idt88:j_idt93")).click();
        driver.switchTo().alert().dismiss();
       String text = driver.findElement(By.id("result")).getText();
       Assert.assertEquals(text,"User Clicked : Cancel");

    }

    @Test
    public void frame(){
        driver.get("https://leafground.com/frame.xhtml;jsessionid=node01q23e7ap4qlq0312y9ixvg37987032.node0");
        driver.switchTo().frame(0);
        driver.findElement(By.id("Click")).click();
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"page.xhtml\"]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"framebutton.xhtml\"]")));
        driver.findElement(By.id("Click")).click();
        driver.switchTo().parentFrame();


    }

    @Test
    public void dragDrop(){
    driver.get("https://leafground.com/drag.xhtml;jsessionid=node01q23e7ap4qlq0312y9ixvg37987032.node0");
            Actions actions = new Actions(driver);
         // actions.dragAndDrop(driver.findElement(By.id("form:cononl")),100,100).perform();
          WebElement source = driver.findElement(By.id("form:drop"));
       //   actions.dragAndDrop(source,destination).perform();
       //   actions.moveToElement().doubleClick().perform();


    }
    @Test
    public void windowTest(){
        driver.get("https://leafground.com/window.xhtml;jsessionid=node01q23e7ap4qlq0312y9ixvg37987032.node0");
        driver.findElement(By.id("j_idt88:new")).click();
        Set<String> windowSet = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowSet);
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://leafground.com/dashboard.xhtml"));
        driver.close();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
