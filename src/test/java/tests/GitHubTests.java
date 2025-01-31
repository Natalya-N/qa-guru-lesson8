package tests;

import data.TopMenuList;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests extends TestBase {

    @Tag("SMOKE")
    @ValueSource(strings = {
        "JUnit",
        "Selenide",
        "Java"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен возвращаться не пустой список найденных репозиториев")
    void searchResultsShouldNotBeEmptyTest(String searchString) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[data-target='query-builder.input']").setValue(searchString).pressEnter();
        $$("[data-hpc='true']")
                .shouldBe(sizeGreaterThan(0));
    }

    @EnumSource(TopMenuList.class)
    @Tag("SMOKE")
    @ParameterizedTest(name = "В верхнем меню отображается заглавие выпадающего списка: {0}")
    void checkTopMenuTest(TopMenuList topMenuList) {
        $x("button[contains(text(), ' " + topMenuList + " ')]").shouldHave(text(topMenuList.description));
    }

    @Tag("SMOKE")
    @CsvFileSource(resources = "/checkSearchResultsTest.csv")
    @ParameterizedTest(name = "Для поискового запроса должен возвращаться список репозиториев," +
            "Для каждого репозитория должна возвращаться ссылка: {1}, " +
            "название репозитория: {2}")
    void checkSearchResultsTest(String link, String name) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[data-target='query-builder.input']").setValue("selenide").pressEnter();
        $("[data-testid='results-list']").shouldHave(text(link));
        $("[data-testid='results-list']").shouldHave(text(name));
    }

    static Stream<Arguments> checkPricesTest() {
        return Stream.of(
                Arguments.of(
                        "Free",
                        "0"),
                Arguments.of(
                        "Team",
                        "4"),
                Arguments.of(
                        "Enterprise",
                        "21")
        );
    }

    @Tag("SMOKE")
    @MethodSource
    @ParameterizedTest(name = "Проверка тарифа {0} и стоимости {1}")
    void checkPricesTest(String option, String price) {
        open("pricing");
        $("[class='p-responsive container-xl text-center']").shouldHave(text(option));
        $("[class='p-responsive container-xl text-center']").shouldHave(text(price));
    }
}
