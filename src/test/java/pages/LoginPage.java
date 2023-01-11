package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //Заголовок "Вход"
    private By entrance = By.xpath(".//h2[text()='Вход']");

    //Поле для ввода "Email"
    private By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']");

    //Поле для ввода "Пароль"
    private By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']");

    //Кнопка "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");

    //Ссылка "Зарегистрироваться"
    private By register = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");

    //Ссылка "Восстановить пароль"
    private By forgotPassword = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Ввод Email-а
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //Ввод пароля
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    //Клик по кнопке "Войти"
    public void clickOnEntrance(){
        driver.findElement(entrance).click();
    }
    //Клик по ссылке "Зарегистрироваться"
    public void clickOnRegister(){
        driver.findElement(register).click();
    }
    //Клик по ссылке "Восстановить пароль"
    public void clickOnForgotPassword(){
        driver.findElement(forgotPassword).click();
    }
    //Авторизация пользователя
    public void authorization(String email, String password){
        setEmail(email);
        setPassword(password);
        clickOnEntrance();
    }

}
