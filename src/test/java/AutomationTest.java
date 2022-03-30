import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    @Parameters ({"email","idOrder","message"})
    public void automationTest(String email, String idOrder, String message){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[title='Contact Us']")).click();

        Select subjectHeading = new Select(driver.findElement(By.cssSelector("#id_contact")));
        subjectHeading.selectByValue("2");

        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#id_order")).sendKeys(idOrder);
        driver.findElement(By.cssSelector("#message")).sendKeys(message);
        driver.findElement(By.cssSelector("#submitMessage")).click();



    }





}
