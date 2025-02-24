package ru.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondOrderPageScooter {

    private WebDriver driver;

    //Локаторы кнопок
    private final By pageOrderButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Заказать']");
    private final By overlayYesButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']");

    //Локатор сообщения об успешном заказе
    private final By overlayOrderConfirmation = By.xpath("//*[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");

    //Локаторы полей
    private final By dateField = By.cssSelector(".react-datepicker__input-container>input");
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    private final By commentField = By.xpath("//*[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");

    private By selectedDate;
    private By selectedPeriod;
    private By selectedColor;

    //Конструктор класса
    public SecondOrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для заполнения полей
    public void selectDate(String date) {
        driver.findElement(dateField).click();
        selectedDate = By.xpath(String.format("//div[contains(@aria-label, '%s')]",date));
        driver.findElement(selectedDate).click();
    }

    public void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        selectedPeriod = By.xpath(String.format("//*[@class='Dropdown-option'][text()='%s']", rentalPeriod));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(selectedPeriod));
        driver.findElement(selectedPeriod).click();
    }

    public void selectScooterColor(String scooterColor) {
        selectedColor = By.cssSelector(String.format("#%s",scooterColor));
        driver.findElement(selectedColor).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void fillInAllFields(String date, String rentalPeriod, String scooterColor, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(dateField));
        selectDate(date);
        selectRentalPeriod(rentalPeriod);
        selectScooterColor(scooterColor);
        setComment(comment);
    }

    //Метод для клика по кнопка "Да" и "Закзать"
    public void clickOrderAndConfirmationButtons() {
        driver.findElement(pageOrderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(overlayYesButton));
        driver.findElement(overlayYesButton).click();
    }

    //Метод для проверки появляения сообщения об успешном заказе
    public boolean checkOrderConfirmationMessage() {
        new WebDriverWait(driver,Duration.ofSeconds(5));
        return !driver.findElements(overlayOrderConfirmation).isEmpty();
    }

}
