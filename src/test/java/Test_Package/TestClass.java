package Test_Package;

import Pages_Package.Home_Page;
import Pages_Package.Time_Material_Class;
import Pages_Package.LoginPageClass;
import Utilities_Package.CommonClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestClass extends CommonClass
{

    @BeforeTest
    //get url from testng.xml file

    @Parameters({"URL"})
    public void Set_Up_TM(String url) throws IOException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(url);

        //driver.get("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");
        driver.manage().window().maximize();


        LoginPageClass loginPage_Obj = new LoginPageClass();
        loginPage_Obj.Login_HomePage_Verification(driver);

        Home_Page timeAndMaterial_Obj = new Home_Page();
        timeAndMaterial_Obj.Click_TM_and_Create(driver);

    }

    //test-01
    @Test(priority = 1)


    public void Create_TM_Record() throws InterruptedException {

        Time_Material_Class createEditDelete_Obj = new Time_Material_Class();
        createEditDelete_Obj.Create_Time_And_Material(driver);
    }

    //Test-02

    @Test(priority = 2 )


    public void Edit_Time_Record()
    {
        Time_Material_Class createEditDelete_Obj = new Time_Material_Class();
        createEditDelete_Obj.Edit_Time_And_Material(driver);
    }

    //Test-03


    @Test(priority = 3)
    public void Delete_Time_Record()
    {
        Time_Material_Class createEditDelete_Obj = new Time_Material_Class();
        createEditDelete_Obj.Delete_Time_And_Material(driver);
    }

    @AfterTest
    public void CloseTest()
    {
        driver.close();


    }
}



