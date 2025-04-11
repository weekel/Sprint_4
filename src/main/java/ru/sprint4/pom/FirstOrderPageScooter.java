package ru.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstOrderPageScooter {

    private WebDriver driver;

    //Локаторы кнопок
    private final By nextButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Далее']");

    //Локаторы полей
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.className("select-search");
    private final By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By selectedStation;


    //Конструктор класса
    public FirstOrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для введения данных в поля
    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        selectedStation = By.xpath(String.format("//*[@class='select-search__select']//div[text()='%s']", metroStation));
        driver.findElement(selectedStation).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void fillInAllFields(String name, String surname, String address, String metroStation, String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(nameField));
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
    }

    //Метод для клика по кнопке "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
}
