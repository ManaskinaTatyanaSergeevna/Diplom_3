package tests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class TransitionInProfilePageTest {

    private WebDriver driver;
    private final static String EMAIL = "test-data@yandex.ru";
    private final static String PASSWORD = "password";

    @Test
    public void transitionToProfilePageChromeTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEntrance();
        Assert.assertTrue("Страница авторизации не отобразилась.",
                driver.findElement(loginPage.entrance).isDisplayed());
    }

    @Test
    public void transitionToProfilePageYandexTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\yandexdriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEntrance();
        Assert.assertTrue("Страница авторизации не отобразилась.",
                driver.findElement(loginPage.entrance).isDisplayed());
    }

    @Test
    public void transitionToProfilePageWithAuthUserChromeTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEntrance();
        loginPage.authorization(EMAIL, PASSWORD);
        mainPage.waitForLoadMainPage();
        mainPage.clickOnAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForLoadProfilePage();
        Assert.assertTrue("Страница личного кабинета не прогрузилась",
                driver.findElement(profilePage.textOnProfilePage).isDisplayed());
    }

    @Test
    public void transitionToProfilePageWithAuthUserYandexTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\danii\\IdeaProjects\\ЯндексПроектики\\diplom\\Diplom_3\\src\\main\\resources\\drivers\\yandexdriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadEntrance();
        loginPage.authorization(EMAIL, PASSWORD);
        mainPage.waitForLoadMainPage();
        mainPage.clickOnAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForLoadProfilePage();
        Assert.assertTrue("Страница личного кабинета не прогрузилась",
                driver.findElement(profilePage.textOnProfilePage).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
