package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
     void beforeEach() {
        open(Configuration.baseUrl);
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }

}
