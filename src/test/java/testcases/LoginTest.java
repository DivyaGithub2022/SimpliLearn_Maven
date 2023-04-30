package testcases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import org.testng.AssertJUnit;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseClass{
	
	@Test
	public void test1() {
		
		LoginPage login = new LoginPage(driver);
		//either you need to have this driver initializing in each of the method.
		//Or you can define this under a method and call the method in each methods test1 & test2
		login.LoginFunction("abc@xyz.com","Abc@12345");
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String ActError = error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		AssertJUnit.assertEquals(ActError, ExpError);
	}
	
	@Test
	public void test2() {
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("pqr@xyz.com","Abc@12345");
	}
	
	@Test
	public void test4(Method method) throws FilloException {
		
		Recordset recordset = connection.executeQuery("select * from data where TestName = '" + method.getName() + "'");
//("select * from data where TestName='test4'"); - hardcoding - we are using the excel data sheet name not the file name
		//if you need to run all data in one set/method, separate out the input data with ; or , and write split command /for loop to run it in Array
		recordset.next();
		
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
	}
	
	
}
