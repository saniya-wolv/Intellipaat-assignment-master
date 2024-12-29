package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationMappingSteps {
    WebDriver driver;
    WebElement currencyElement;
    @Given("User launch the browser and nagivates to the URL")
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

      driver.get("https://login.salesforce.com/");
    }

    @When("User enters the username {string}  and password {string}")
    public void userEntersTheUsernameAndPassword(String userName, String Password) {
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
//        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys(Password);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector(".input.r4.wide.mb16.mt8.password")).sendKeys(Password);

        //Handling linkText  ( applicable only for hyperlink)
     //   driver.findElement(By.linkText("Forgot Your Password?")).click();
    //    driver.findElement(By.partialLinkText("Forgot You")).click();

    }

    @And("user clicks the login button")
    public void clickLoginButton(){
        driver.findElement(By.id("Login")).click();
    }

    @Then("Validating the error message")
    public void validatingTheErrorMessage() {
        String ErrorMessageactual = driver.findElement(By.id("error")).getText();
        String ErrorMessageExpected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        if(ErrorMessageactual.equals(ErrorMessageExpected)){
            System.out.println("Equal");
        }else {
            System.out.println(" Error message is NOT Equal");

        }
    }

    @Then("Validate whether the user is nagivated to the Homepage.")
    public void validateWhetherTheUserIsNagivatedToTheHomepage() {
    }


    //This is for handling static dropdown value

    @Given("User launch the browser and nagivates to the spicejet website")
    public void visitWebsite() {
        driver.get("https://www.spicejet.com/");
    }

    @When("user selects the specific dropdrown value")
    public void handlingStaticDropdown() {

        currencyElement = driver.findElement(By.id("select-demo"));
        Select selectCurrency = new Select(currencyElement);
        selectCurrency.selectByValue("Sunday");
        // selectCurrency.selectByIndex(3);
        // selectCurrency.selectByVisibleText("Java");
        // driver.findElement(By.id("APjFqb")).sendKeys("Saniya Gazala" + Keys.ENTER);


    }

    @And("user iterates the dropdown values")
    public void iteratingStaticDropDown() {
     int currencyDropdownSize  =  currencyElement.findElements(By.tagName("option")).size();
        for ( int i = 0; i < currencyDropdownSize ; i++){
         String value =   currencyElement.findElements(By.tagName("option")).get(i).getText();
            System.out.println(value);
        }
    }
}
