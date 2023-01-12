package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    //Кнопка "Войти в аккаунт"
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //Кнопка "Личный кабинет"
    private By accountButton = By.xpath(".//a[@href='/account']");

    //Логотип "Stellar Burgers"
    private By logo = By.xpath(".//div/a[@href='/']");

    //Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");

    //Кнопка перехода "Булки"
    private By bunsButton = By.xpath(".//span[text()='Булки']");
    //Кнопка перехода "Соуса"
    private By saucesButton = By.xpath(".//span[text()='Соусы']");
    //Кнопка перехода "Начинки"
    private By fillingButton = By.xpath(".//span[text()='Начинки']");
//текст для проверки видимости на главной странице
    public By textBurgerMainPage = By.xpath(".//section/h1[text()='Соберите бургер']");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //Клик по кнопке "Войти в аккаунт"
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    //Клик по кнопке "Личный кабинет"
    public void clickOnAccountButton(){
        driver.findElement(accountButton).click();
    }
    //Клик по кнопке "Stellar Burgers"
    public void clickOnLogo(){
        driver.findElement(logo).click();
    }
    //Клик по кнопке "Конструктор"
    public void clickOnConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    //Клик по кнопке "Булки"
    public void clickOnBunsButton(){
        driver.findElement(bunsButton).click();
    }
    //Клик по кнопке "Соуса"
    public void clickOnSaucesButton(){
        driver.findElement(saucesButton).click();
    }
    //Клик по кнопке "Начинки"
    public void clickOnFillingButton(){
        driver.findElement(fillingButton).click();
    }

    public void waitForLoadMainPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textBurgerMainPage));
    }
}
