package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;

    //Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private final By accountButton = By.xpath(".//a[@href='/account']");
    //Логотип "Stellar Burgers"
    private final By logo = By.xpath(".//div/a[@href='/']");
    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //Кнопка перехода "Булки"
    private final By bunsButton = By.xpath(".//div[./span[text()='Булки']]");
    //Кнопка перехода "Соуса"
    private final By saucesButton = By.xpath(".//div[./span[text()='Соусы']]");
    //Кнопка перехода "Начинки"
    private final By fillingsButton = By.xpath(".//div[./span[text()='Начинки']]");

    //поле "Булки" для проверки кликанья раздела
    public By bunsHeader = By.xpath(".//img[@alt='Краторная булка N-200i']");
    public By bunsText = By.xpath(".//h2[text()='Булки']");
    //поле "Соусы" для проверки кликанья раздела
    public By saucesHeader = By.xpath(".//p[text()='Соус с шипами Антарианского плоскоходца']");
    //поле "Начинки" для проверки кликанья раздела
    public By fillingsHeader = By.xpath(".//img[@alt='Плоды Фалленианского дерева']");
    //текст для проверки видимости на главной странице
    public By textBurgerMainPage = By.xpath(".//section/h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке "Войти в аккаунт"
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
        waitForInvisibilityLoadingAnimation();
    }

    //Клик по кнопке "Личный кабинет"
    public void clickOnAccountButton() {
        driver.findElement(accountButton).click();
        waitForInvisibilityLoadingAnimation();
    }

    //Клик по кнопке "Stellar Burgers"
    public void clickOnLogo() {
        driver.findElement(logo).click();
        waitForInvisibilityLoadingAnimation();
    }

    //Клик по кнопке "Конструктор"
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
        waitForInvisibilityLoadingAnimation();
    }

    //Клик по кнопке "Булки"
    public void clickOnBunsButton() {
        driver.findElement(bunsButton).click();
        waitForInvisibilityLoadingAnimation();

    }

    //Клик по кнопке "Соуса"
    public void clickOnSaucesButton() {
        driver.findElement(saucesButton).click();
        waitForInvisibilityLoadingAnimation();
    }

    //Клик по кнопке "Начинки"
    public void clickOnFillingButton() {
        driver.findElement(fillingsButton).click();
        waitForInvisibilityLoadingAnimation();
    }

    //ждем когда загрузится главная страница и будет виден текст "Соберите бургер"
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(textBurgerMainPage));
    }

    //ждем когда загрузится текст с булками на главной странице(?)
    public void waitForLoadBunsHeader() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(bunsHeader));
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'_menuContainer')]//ul)[last()]/a")));
    }

    //ждем когда загрузится текст с соусами на главной странице(?)
    public void waitForLoadSaucesHeader() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(saucesHeader));
        waitDocReady();
    }

    //ждем когда загрузится текст с начинками на главной странице(?)
    public void waitForLoadFillingsHeader() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsHeader));
        waitDocReady();
    }

    // ждем когда загрузится страница полностью, исчезнет анимация
    public void waitForInvisibilityLoadingAnimation() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']")));
        waitDocReady();
    }

    public void waitDocReady() {
        new WebDriverWait(driver, 30)
                .until((ExpectedCondition<Boolean>) wd ->
                        ((JavascriptExecutor) wd)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }

}
