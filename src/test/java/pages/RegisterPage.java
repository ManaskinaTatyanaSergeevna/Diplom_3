package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    //Поле "Имя"
    private By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");

    //Поле "Email"
    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");

    //Поле "Пароль"
    private By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");

    //Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Текст "Некорректный пароль"
    public By errorPasswordText = By.xpath(".//p[text()='Некорректный пароль']");


    private WebDriver driver;

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
    }
    //Регистрация пользователя
    public void registration(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickOnRegisterButton();
    }
}
