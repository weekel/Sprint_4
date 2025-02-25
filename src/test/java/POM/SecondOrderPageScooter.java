package POM;

import org.junit.Assert;
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

    //Конструктор класса
    public SecondOrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для заполнения полей
    public void selectDate(String date) {
        driver.findElement(dateField).click();
        String selectedDate = String.format("//div[contains(@aria-label, '%s')]",date);
        driver.findElement(By.xpath(selectedDate)).click();
    }

    public void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        String selectedPeriod = String.format("//*[@class='Dropdown-option'][text()='%s']", rentalPeriod);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedPeriod)));
        driver.findElement(By.xpath(selectedPeriod)).click();
    }

    public void selectScooterColor(String scooterColor) {
        String selectedColor = String.format("#%s",scooterColor);
        driver.findElement(By.cssSelector(selectedColor)).click();
    }

    public void fillInAllFields(String date, String rentalPeriod, String scooterColor, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(dateField));
        selectDate(date);
        selectRentalPeriod(rentalPeriod);
        selectScooterColor(scooterColor);
        driver.findElement(commentField).sendKeys(comment);
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
