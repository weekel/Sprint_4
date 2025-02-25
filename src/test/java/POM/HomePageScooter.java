package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageScooter {

    private WebDriver driver;

    //Локатор кнопки принятия cookies
    private final By cookieButton = By.id("rcc-confirm-button");

    //Локаторы кнопок "Заказать"
    private final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC>.Button_Button__ra12g");
    private final By pageOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //Локаторы вопросов из раздела "Вопросы о важном"
    private final By[] faqQuestions = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };


    //Локаторы ответов из раздела "Вопросы о важном"
    private final By[] faqAnswers = {
            By.cssSelector("#accordion__panel-0 > p"),
            By.cssSelector("#accordion__panel-1 > p"),
            By.cssSelector("#accordion__panel-2 > p"),
            By.cssSelector("#accordion__panel-3 > p"),
            By.cssSelector("#accordion__panel-4 > p"),
            By.cssSelector("#accordion__panel-5 > p"),
            By.cssSelector("#accordion__panel-6 > p"),
            By.cssSelector("#accordion__panel-7 > p")
    };

    //Конструтор класса
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }


    //Методы для тестов раздела "Вопросы о важном"
    public void clickFaqQuestion(int index) {
        driver.findElement(cookieButton).click();
        driver.findElement(faqQuestions[index]).click();
    }

    public String getFaqAnswerText(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(faqAnswers[index]));
        return driver.findElement(faqAnswers[index]).getText();
    }

    //Методы для тестов заказов
    public void clickHeaderOrderButton() {
        driver.findElement(cookieButton).click();
        driver.findElement(headerOrderButton).click();
    }

    public void clickPageOrderButton() {
        driver.findElement(cookieButton).click();
        driver.findElement(pageOrderButton).click();
    }




}
