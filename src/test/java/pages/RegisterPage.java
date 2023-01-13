package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    //Поле "Имя"
    private By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    //Поле Email"
    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    //Поле "Пароль"
    private By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    //Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Текст "Некорректный пароль"
    public By errorPasswordText = By.xpath(".//p[text()='Некорректный пароль']");
    //Текст для проверки перехода на страницу регистрации
    public By registerText = By.xpath(".//div/h2[text()='Регистрация']");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }


    //Ввод имени
    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    //Ввод Email-а
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //Ввод пароля
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    //Клик по кнопке "Зарегистрироваться"
    public void clickOnRegisterButton(){
        driver.findElement(registerButton).click();
        waitForInvisibilityLoadingAnimation();
    }
    //Регистрация пользователя
    public void registration(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickOnRegisterButton();
    }
    //ждем когда загрузится страница регистрации через текст "регистрация"
    public void waitForLoadRegisterPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registerText));
    }
    // ждем когда загрузится страница полностью, исчезнет анимация
    public  void waitForInvisibilityLoadingAnimation() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']")));
    }
}
