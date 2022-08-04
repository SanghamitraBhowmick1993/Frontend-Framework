package AppHooks;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;

public class AppHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;

	
	@Before(order = 0)
	public void getProperty(){
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}
	  @BeforeMethod
	    public void setUpSparktest(ITestResult result){
	        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
	        ExtentReport.setTest(test);
	    }
	
	@Before(order = 1)
	public void launchBrowser(){
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);
	}
	
	@After(order =0)
	public void quit(){
		driver.quit();
	}
	
	@AfterMethod
	    public void SparktestResult(ITestResult result) throws IOException {
	        if(!result.isSuccess()){
	            ExtentReport.getTest().log(Status.FAIL, "test case failed as - " +
	                    result.getThrowable());
	            String screenshotPath = Util.getScreenshot(result.getMethod().getMethodName()+".png");

	             /*ExtentReport.getTest()
	                    .addScreenCaptureFromPath(screenshotPath)
	                    .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	                    */
	            ExtentReport.getTest().fail(MediaEntityBuilder
	                    .createScreenCaptureFromBase64String(Util.convertImg_Base64(screenshotPath)).build());
	        }
	    }
			
	@After(order =1)
    public void sparkFlush(){
        ExtentManager.getInstance().flush();
    }
}
		
			
			

		
	

