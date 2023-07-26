package qaguruTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenSelenideInGithubTest extends testjUnit5codeTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openSelenide() {
        //ввести в поле поиска "Selenide" и нажать Enter
        open("https://github.com");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[data-target='query-builder.input']").setValue("selenide").pressEnter();
        $("div.search-title a").click();
        //открыть Wiki
        $("#wiki-tab").click();
        //в списке страниц Wiki есть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft assertions"));
        //открыть SoftAssertions
        $(".markdown-body").$(byText("Soft assertions")).click();
        // проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0).shouldHave(text(code));
    }
}