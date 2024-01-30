package Pages_Package;
import Utilities_Package.WaitHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Time_Material_Class {
    public void Create_Time_And_Material(WebDriver driver ) throws InterruptedException {
        WebElement click_create = driver.findElement(By.xpath("//a[@href='/TimeMaterial/Create']"));
        click_create.click();

        WaitHelper.WaitToBeClickable(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]", 2);



        WebElement typeCode = driver.findElement(By.xpath("//span[contains(text(),'Material')]"));
        typeCode.click();

        WaitHelper.WaitToBeClickable(driver, "xpath", "//*[@id='TypeCode_listbox']/li[1]", 2);


        WebElement drop_down_button = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        drop_down_button.click();



        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.sendKeys("Koshi Jacob 123");


        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys("Automation Demo in Time and Materials");

        WebElement priceTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceTag.click();

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        pricePerUnit.sendKeys("40");


        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.submit();
        System.out.println("Time and Materials created and submitted");


        //click on lastpage icon and check the given code



        WaitHelper.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 20);


        WebElement selectLastPage = driver.findElement(By.xpath("//span[contains(text(),'last page')]"));
        selectLastPage.click();

        WebElement savedData = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        String data = savedData.getText();
        Assert.assertEquals(data , "Koshi Jacob 123");

    }

    public void Edit_Time_And_Material(WebDriver driver)
    {
        WaitHelper.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 10);

        //Edit the given data

        WebElement clickOnEditButton = driver.findElement(By.xpath("//tbody/tr[6]/td[5]/a[1]"));
        clickOnEditButton.click();


        WebElement editCodeType = driver.findElement(By.xpath("//span[contains(text(),'Time')]"));
        editCodeType.click();


        WebElement selectDropDown = driver.findElement(By.xpath("//span[contains(text(),'select')]"));
        selectDropDown.click();

        WaitHelper.WaitToBeClickable(driver, "xpath", "//*[@id='Code']", 5);


        WebElement editCode = driver.findElement(By.id("Code"));
        editCode.clear();
        editCode.sendKeys("Koshiya Jacob");


        WebElement editDescription = driver.findElement(By.id("Description"));
        editDescription.clear();
        editDescription.sendKeys("Edited Automation Code");

        WebElement priceInputTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag.click();

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        priceInputTag.click();
        pricePerUnit.sendKeys("20");


        WebElement save_button = driver.findElement(By.id("SaveButton"));
        save_button.click();

        System.out.println("Edited the data Successfully");

    }

    public void Delete_Time_And_Material(WebDriver driver)
    {
        WebElement lastPageIcon = driver.findElement(By.linkText("Go to the last page"));
        lastPageIcon.click();


        //click on Delete button

        WebElement clickDelete = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/a[2]"));
        clickDelete.click();


        Alert alert = driver.switchTo().alert();
        String alertBox = alert.getText();
        System.out.println("Alert box text" + alertBox);
        alert.accept();

        //Taking Screenshot and save

//        try
//        {
//            Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
//            ss.SaveAsFile(@"D:\Screenshot\SeleniumTestingScreenshot.jpg");
//            Console.WriteLine("Screenshot saved");
//        }
//        catch (Exception e)
//        {
//            Console.WriteLine(e.Message);
//            throw;
//        }
        //Logout

        WebElement helloHari = driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li/a"));
        helloHari.click();

        WebElement dropDownField = driver.findElement(By.xpath("//a[contains(text(),'Log off')]"));
        dropDownField.click();

        //Retrieve the Current page url:

        String url = driver.getCurrentUrl();
        System.out.println(url);

        //string url = driver.Url;
        //Console.WriteLine(url);



    }
}

