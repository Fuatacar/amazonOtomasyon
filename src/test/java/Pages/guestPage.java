package Pages;

import org.openqa.selenium.WebDriver;

public class guestPage extends BasePage {

    public final String popUpClose = "//input[@id='sp-cc-accept']";  //xpath
    public final String girisyapbutton = "nav-link-accountList-nav-line-1";  //id




    public guestPage(WebDriver driver) {
        super(driver);
    }

}