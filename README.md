# Diplom_3 

Учебный проект по автотестированию UI для приложения по заказу бургеров Stellar Burgers.

## Описание

Версия Java 11.

В проекте тестируется функциональность в Google Chrome и Яндекс.Браузере.

Проект использует следующие библиотеки:
- JUnit 4
- Selenium
- Allure

## Документация

[Ссылка](https://stellarburgers.nomoreparties.site) на учебное приложение.

### Запуск автотестов

Для запуска автотестов необходимо:

1. Скачать код

 ```sh
   git clone https://github.com/ManaskinaTatyanaSergeevna/Diplom_3.git
   ```
   
2. Запустить команду в проекте

```sh
mvn clean test
```

3. Для создания отчета в Allure ввести команду

```sh
mvn allure:report
```

### Структура проекта

```bash
.gitignore
pom.xml
README.md
src
   |-- main
   |   |-- java
   |   |-- resources
   |   |   |-- drivers
   |   |   |   |-- chromedriver.exe
   |   |   |   |-- yandexdriver.exe
   |-- test
   |   |-- java
   |   |   |-- tests
   |   |   |   |-- LoginTest.java
   |   |   |   |-- RegistrationTest.java
   |   |   |   |-- TransitionInConstructorTest.java
   |   |   |   |-- TransitionInProfilePageTest.java
   |   |   |-- pages
   |   |   |   |-- LoginPage.java
   |   |   |   |-- MainPage.java
   |   |   |   |-- ProfilePage.java
   |   |   |   |-- RecoverPasswordPage.java
   |   |   |   |-- RegisterPage.java
   ```
