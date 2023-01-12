package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;


public class RegistrationTest {

    private WebDriver driver;

    @Test
    public void successRegistrationChromeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        String name = RandomStringUtils.randomAlphanumeric(4, 8);
        String email = RandomStringUtils.randomAlphanumeric(6, 10) + "@" + RandomStringUtils.randomAlphanumeric(2, 8) + ".ru";
        String password = RandomStringUtils.randomAlphanumeric(10, 20);
        registerPage.registration(name, email, password);
        loginPage.waitForLoadEntrance();
        Assert.assertTrue("Страница авторизации не отобразилась.",
                 driver.findElement(loginPage.entrance).isDisplayed());
    }

    @Test
    public void successRegistrationYandexTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\yandexdriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        String name = RandomStringUtils.randomAlphanumeric(4, 8);
        String email = RandomStringUtils.randomAlphanumeric(6, 10) + "@" + RandomStringUtils.randomAlphanumeric(2, 8) + ".ru";
        String password = RandomStringUtils.randomAlphanumeric(10, 20);
        registerPage.registration(name, email, password);
        loginPage.waitForLoadEntrance();
        Assert.assertTrue("Страница авторизации не отобразилась.",
                 driver.findElement(loginPage.entrance).isDisplayed());
    }


    @Test
    public void failedRegistrationChromeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        String name = RandomStringUtils.randomAlphanumeric(4, 8);
        String email = RandomStringUtils.randomAlphanumeric(6, 10) + "@" + RandomStringUtils.randomAlphanumeric(2, 8) + ".ru";
        String password = RandomStringUtils.randomAlphanumeric(0, 5);
        registerPage.registration(name, email, password);
        Assert.assertTrue("Пароль введен корректно.",
                 driver.findElement(registerPage.errorPasswordText).isDisplayed());
    }

    @Test
    public void failedRegistrationYandexTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\yandexdriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        String name = RandomStringUtils.randomAlphanumeric(4, 8);
        String email = RandomStringUtils.randomAlphanumeric(6, 10) + "@" + RandomStringUtils.randomAlphanumeric(2, 8) + ".ru";
        String password = RandomStringUtils.randomAlphanumeric(0, 5);
        registerPage.registration(name, email, password);
        Assert.assertTrue("Пароль введен корректно.",
                driver.findElement(registerPage.errorPasswordText).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
