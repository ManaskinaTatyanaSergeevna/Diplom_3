package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    //Поле "Email"
    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");

    //Кнопка "Восстановить"
    private By recoverButton = By.xpath(".//form/button[text()='Восстановить']");

    //Заголовок "Восстановление пароля"
    private By recoverPassword = By.xpath(".//main/div/h2[text()='Восстановление пароля']");

    private WebDriver driver;

    public RecoverPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    //Ввод Email
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //Клик по кнопке "Восстановить"
    public void clickOnRecoverButton(){
        driver.findElement(recoverButton).click();
    }
    //Восстановление пароля
    public void recoverPassword(String email){
        setEmail(email);
        clickOnRecoverButton();
    }
}
