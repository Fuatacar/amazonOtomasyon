package Pages;

import org.openqa.selenium.WebDriver;

public class loginPage extends BasePage {

    public final String emailgirbutton = "//input[@id='ap_email']";  //xpath
    public final String continuebutton = "//input[@id='continue']";  //xpath
    public final String sifregirbutton = "//input[@id='ap_password']";  //xpath
    public final String loginbutton = "//input[@id='signInSubmit']";  //xpath


    public loginPage(WebDriver driver) {
        super(driver);
    }
}

