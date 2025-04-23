# 🖥️ QA Scooter UI Tests

This project contains automated **UI tests** for the QA Scooter web application using Selenium WebDriver and JUnit 4.  
It validates user interactions such as placing orders and viewing the FAQ section.

---

## 📁 Project Structure

- `src/main/java/ru/sprint4/pom/` – Page Object classes for UI components
- `src/test/java/` – Test classes:
  - `TestsOrder` – Verifies order flow
  - `TestFAQ` – Verifies FAQ interactions
- `pom.xml` – Maven build configuration

---

## ✅ Technologies Used

- **Java 11**
- **JUnit 4** – for organizing tests
- **Selenium WebDriver** – for browser automation
- **Maven** – for dependency and build management

---

## 🚀 How to Run Tests

Make sure you have **Java 11+**, **Maven**, and **ChromeDriver** installed.

To run the tests:

```bash
mvn clean test
```

---

## 🧪 Features Tested

- ✅ Filling out and submitting order form
- ✅ Selecting date, rental period, scooter color
- ✅ FAQ expand/collapse behavior
- ✅ Field validation and negative cases

---

## 🌐 Browser Support

Tests are written for **Google Chrome**. To test in other browsers, configure your WebDriver accordingly.

---

## 📄 License

This is an educational project developed as part of a test automation course.
