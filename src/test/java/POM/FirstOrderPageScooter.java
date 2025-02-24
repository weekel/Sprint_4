package POM;

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
    private final By nameField = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    private final By surnameField = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    private final By addressField = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    private final By metroStationField = By.className("select-search");
    private final By phoneNumberField = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");


    //Конструктор класса
    public FirstOrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для введения данных в поля
    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        String selectedStation = String.format("//*[@class='select-search__select']//div[text()='%s']", metroStation);
        driver.findElement(By.xpath(selectedStation)).click();
    }

    public void fillInAllFields(String name, String surname, String address, String metroStation, String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        selectMetroStation(metroStation);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Метод для клика по кнопке "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
}
