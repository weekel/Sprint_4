import ru.sprint4.pom.FirstOrderPageScooter;
import ru.sprint4.pom.HomePageScooter;
import ru.sprint4.pom.SecondOrderPageScooter;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;


@RunWith(Parameterized.class)
public class TestsOrder extends BaseTest{
    private HomePageScooter objHomePageScooter;
    private FirstOrderPageScooter objFirstOrderPageScooter;
    private SecondOrderPageScooter objSecondOrderPageScooter;

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;

    private final String date;
    private final String rentalPeriod;
    private final String scooterColor;
    private final String comment;

    public TestsOrder(String name, String surname, String address, String metroStation, String phoneNumber,
                      String date, String rentalPeriod, String scooterColor, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this. metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldsData() {
        return new Object[][] {
                {"Ян", "Ли", "Горки", "Преображенская площадь", "+78887776655", "2-е марта 2025", "двое суток", "black", "Буду где-то около домов"},
                {"Юля","Али", "Ул. По", "Красносельская", "+78887776656", "28-е февраля 2025", "шестеро суток", "grey", "Позвоните перед приездом"},
                {"Екатеринослава ", "Тестировщикова", "Улица Дружбы Народов и Молодёжного Проспекта, 323", "Чистые пруды", "+78887676655", "1-е марта 2025", "трое суток", "grey", ""},
                {"Ядвигамирослава", "Содержимополева", "Улица Дружбы и Молодёжного Проспекта, 323", "Охотный Ряд", "+78897776655", "28-е февраля 2025", "сутки", "black", "Хочу 4 колеса"}
        };
    }

    @Before
    public void initPages() {
        objHomePageScooter = new HomePageScooter(driver);
        objFirstOrderPageScooter = new FirstOrderPageScooter(driver);
        objSecondOrderPageScooter = new SecondOrderPageScooter(driver);

    }

    @Test
    public void OrderPositiveTestHeaderButton() {
        objHomePageScooter.clickHeaderOrderButton();
        objFirstOrderPageScooter.fillInAllFields(name, surname, address, metroStation, phoneNumber);
        objFirstOrderPageScooter.clickNextButton();
        objSecondOrderPageScooter.fillInAllFields(date, rentalPeriod, scooterColor, comment);
        objSecondOrderPageScooter.clickOrderAndConfirmationButtons();
        Assert.assertTrue("Сообщение о подтверждении заказ не появилось", objSecondOrderPageScooter.checkOrderConfirmationMessage());
    }

    @Test
    public void OrderPositiveTestPageButton() {
        objHomePageScooter.clickPageOrderButton();
        objFirstOrderPageScooter.fillInAllFields(name, surname, address, metroStation, phoneNumber);
        objFirstOrderPageScooter.clickNextButton();
        objSecondOrderPageScooter.fillInAllFields(date, rentalPeriod, scooterColor, comment);
        objSecondOrderPageScooter.clickOrderAndConfirmationButtons();
        Assert.assertTrue("Сообщение о подтверждении заказ не появилось", objSecondOrderPageScooter.checkOrderConfirmationMessage());
    }
}
