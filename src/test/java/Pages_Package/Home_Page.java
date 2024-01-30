package Pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page
{
    public void Click_TM_and_Create(WebDriver driver)
    {
        WebElement click_administration = driver.findElement(By.xpath("//div/div/ul/li/a[@href='#']"));
        click_administration.click();



        WebElement clickTM = driver.findElement(By.linkText("Time & Materials"));
        clickTM.click();
        System.out.println("User clicked on Time and Materials");

    }
}

