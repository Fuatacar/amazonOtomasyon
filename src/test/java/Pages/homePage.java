package Pages;

import org.openqa.selenium.WebDriver;

public class homePage extends BasePage{

    public final String searchbar = "//input[@type='text']"; //xpath

    public final String amazonLogo ="//a[@id='nav-logo-sprites']"; // xpath







    public homePage(WebDriver driver){
        super(driver);
    }

}