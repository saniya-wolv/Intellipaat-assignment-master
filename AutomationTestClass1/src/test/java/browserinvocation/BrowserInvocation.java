package browserinvocation;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInvocation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("xpathtest");
       // driver.findElement(By.id("username")).sendKeys("saniyagazala");
        //Xpath helps find all the elements  ( Syntax : //tagname[@attribute='value'])
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("saniya@123");
        driver.findElement(By.id("Login")).click();
        String ErrorMessageactual = driver.findElement(By.id("error")).getText();
        String ErrorMessageExpected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        if(ErrorMessageactual.equals(ErrorMessageExpected)){
            System.out.println("Equal");
        }else{
            System.out.println(" Error message is NOT Equal");

        }

driver.quit();
    }

}
