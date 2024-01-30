package Pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPageClass
{

    public void Login_HomePage_Verification( WebDriver driver ) throws IOException {

        // to avoid hard coding the user name and password used properties file:

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("src/test/java/Pages_Package/data.properties");
        prop.load(fis);

        //Entering name, password and click on login
        WebElement username = driver.findElement(By.id("UserName"));
        username.sendKeys(prop.getProperty("username"));


        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(prop.getProperty("password"));


        WebElement click_submit = driver.findElement(By.xpath("//input[@type='submit']"));
        click_submit.click();

        //Verify logged in or nor

        WebElement verificationText = driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));
        String Text_Verify = verificationText.getText();
        Assert.assertEquals(Text_Verify , "Hello hari!", "TurnUp Potal Logged in Successfully");

    }

}


