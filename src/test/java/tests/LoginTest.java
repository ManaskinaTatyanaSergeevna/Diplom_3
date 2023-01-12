package tests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoverPasswordPage;
import pages.RegisterPage;

@RunWith(Parameterized.class)
public class LoginTest {

    private WebDriver driver;
    private String driverType;
    private final static String EMAIL = "test-data@yandex.ru";
    private final static String PASSWORD = "password";

    public LoginTest(String driverType){
        this.driverType = driverType;
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\" + this.driverType + ".exe"
        );
    }

    @Parameterized.Parameters
    public static Object[][] getDriver(){
        return new Object[][]{
                {"chromedriver"},
                {"yandexdriver"},
         };
    }


    @Test
    public void authorizationByLoginButtonTest(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(EMAIL, PASSWORD);
        mainPage.waitForLoadMainPage();
        Assert.assertTrue("Авторизация не прошла успешно", driver.findElement(mainPage.textBurgerMainPage).isDisplayed());
    }

    @Test
    public void authorizationByAccountButtonTest(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(EMAIL,PASSWORD);
        mainPage.waitForLoadMainPage();
        Assert.assertTrue("Авторизация не прошла успешно", driver.findElement(mainPage.textBurgerMainPage).isDisplayed());
    }

    @Test
    public void authorizationByRegisterFormTest(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        String name = RandomStringUtils.randomAlphanumeric(4,6);
        String email = RandomStringUtils.randomAlphanumeric(5,8)+"@mail.ru";
        String password = RandomStringUtils.randomAlphanumeric(6,8);
        registerPage.registration(name, email, password);
        loginPage.waitForLoadEntrance();
        loginPage.authorization(email, password);
        mainPage.waitForLoadMainPage();
        Assert.assertTrue("Авторизация не прошла успешно", driver.findElement(mainPage.textBurgerMainPage).isDisplayed());
    }

    @Test
    public void authorizationByRecoverPasswordTest(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnForgotPasswordLink();
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickOnLoginLink();
        loginPage.authorization(EMAIL,PASSWORD);
        mainPage.waitForLoadMainPage();
        Assert.assertTrue("Авторизация не прошла успешно", driver.findElement(mainPage.textBurgerMainPage).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
