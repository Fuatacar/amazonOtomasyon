package Pages;

import org.openqa.selenium.WebDriver;

public class AssertionLocator extends BasePage{

    //* amazon url sine gittim mi locatorları
    public final String expectedUrl = "https://www.amazon.com.tr/";
    private String actualUrl = "";

    public void setActualUrl(String setValue){
        actualUrl = setValue;
    }

    public String getActualUrl(){
        return actualUrl;
    }
//*************












    public AssertionLocator(WebDriver driver) {
        super(driver);
    }
}