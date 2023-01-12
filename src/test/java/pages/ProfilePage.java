package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    //Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//a[@href='/']/p[text()='Конструктор']");

    //Кнопка "Выход"
    private By exitButton = By.xpath(".//li/button[text()='Выход']");

    //Проверочная надпись для перехода в Личный кабинет
    public By textOnProfilePage = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    //Клик по кнопке Конструктор
    public void clickOnConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    //Клик по кнопке выйти
    public void clickOnExitButton(){
        driver.findElement(exitButton).click();
    }

    public void waitForLoadProfilePage(){
        // подожди 3 секунды, чтобы элемент с нужным текстом стал видимым
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textOnProfilePage));
    }

}
