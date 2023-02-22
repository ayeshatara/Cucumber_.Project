package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerTestNG implements ITestListener {


    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompi


    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }
}

  //  public void onTestFailure(ITestResult result) {
//        TakesScreenshot scrShot =((TakesScreenshot) getDriver());
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);//calling method to take ss
//        File DestFile = new File("screenshot/" +result.getName() +"-"
//         + System.currentTimeMillis()+".png");///moving file to new destination
//        try{
//            FileUtils.copyFile(SrcFile,DestFile);
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }
//        }
//
//        ITestResult result1 = result;
//        public void onTestSkipped(ITestResult result1) {
//        }
//
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result1) {
//        }
//
//    public void onTestFailedWithTimeout(ITestResult result1) {
//            this.onTestFailure(result1);
//        }

//    public void onStart(ITestContext context) {
//        }
//
//        public void onFinish(ITestContext context) {
//        }
 //   }


