package Test;

import Pages.guestPage;
import Pages.homePage;
import Pages.loginPage;
import Pages.productsPage;
import Pages.AssertionLocator;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class amazonTest {
    private WebDriver driver;
    private guestPage guestpage;
    private loginPage loginpage;
    private homePage homepage;
    private productsPage productsPage;
    private AssertionLocator assertionlocator;
    @BeforeEach
    void setUp(){
       System.setProperty("webdriver.chrome.driver","src/test/java/chromedriver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        guestpage=new guestPage(driver);
        loginpage=new loginPage(driver);
        homepage=new homePage(driver);
        productsPage = new productsPage(driver);
        assertionlocator=new AssertionLocator(driver);
        driver.get("https://www.amazon.com.tr/");
    }

    @Test
    void amazon() throws InterruptedException{


        //* amazon url sine gittim mi kontrol
        // 23 nisan eklendi
        assertionlocator.setActualUrl(driver.getCurrentUrl());



        assertionlocator.assertEq(assertionlocator.expectedUrl,assertionlocator.getActualUrl());

        //pop-up kapatılır
        guestpage.waitUntilElement("xpath", guestpage.popUpClose);
        guestpage.clickElement("xpath", guestpage.popUpClose);


        //giris yap butonuna tıklar
        guestpage.clickElement("id",guestpage.girisyapbutton);


        //istenilen bilgiler doldurulur
        //mail kısmı
        loginpage.waitUntilElement("xpath",loginpage.emailgirbutton);
        loginpage.clickElement("xpath",loginpage.emailgirbutton);
        loginpage.sendKeysToElement("xpath",loginpage.emailgirbutton,"fuatacar903@gmail.com");
        loginpage.clickElement("xpath",loginpage.continuebutton);
        //sifre kısmı
        loginpage.waitUntilElement("xpath",loginpage.sifregirbutton);
        loginpage.clickElement("xpath",loginpage.sifregirbutton);
        loginpage.sendKeysToElement("xpath",loginpage.sifregirbutton,"Xc.fuı007");
        loginpage.clickElement("xpath",loginpage.loginbutton);

        //*Açılan anasayfada ürün arama textbox'ına "bilgisayar" yazılır ve enter tuşuna basılır



        //**************


        //* verify you are own account?


        homepage.waitUntilElement("xpath",homepage.searchbar);
        homepage.clickElement("xpath",homepage.searchbar);

        // amazon logo gözüküyor mu
        // 23 Nisan eklendi
         homepage.assertElementIsVisible("xpath",homepage.amazonLogo);



        homepage.sendKeysToElement("xpath",homepage.searchbar,"bilgisayar");
        homepage.pressEnterOnElement("xpath",homepage.searchbar);




        // random secilen bilgisayara gider ve tıklar
        productsPage.randomProductSelect();
        //secilen urunu sepete eklemek icin sayfayş asagi kaydirir
        productsPage.asagiKaydir();




    }




    @AfterEach
    void tearDown() throws InterruptedException {

        // driver.quit();
    }



}