import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckForm<string> {

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void selenideSearchTest() {

        String Fn = "Ivan";
        String Ln = "Ivanov";
        String Email = "Ivanov@ivan.ru";
        String Gender = "Other";
        String Mobile = "8005553535";
        String MonthOfBirth = "March";
        String YearOfBirth = "1994";
        String DayOfBirth = "12";
        String Hobby1 = "Sports";
        String Hobby2 = "Reading";
        String Hobby3 = "Music";
        String File = "HW#1.jpg";
        String Addr = "My address";
        String State = "Haryana";
        String City = "Panipat";


        $("#firstName").setValue(Fn);
        $("#lastName").setValue(Ln);
        $("#userEmail").setValue(Email);
        $(byText(Gender)).click();
        $("#userNumber").setValue(Mobile);
        $("#dateOfBirthInput").click();
        $(byText(MonthOfBirth)).click();
        $(byText(YearOfBirth)).click();
        $(byText(DayOfBirth)).click();
        $("#subjectsInput").setValue("SuBjEcT");
        $(byText(Hobby1)).click();
        $(byText(Hobby2)).click();
        $(byText(Hobby3)).click();
        $("#uploadPicture").sendKeys("C:\\Users\\olegp\\Desktop\\auto qa\\HW#2\\src\\Test\\resources\\"+File);
        $("#currentAddress").setValue(Addr);
        $("#submit").scrollTo();
        $("#state").click();
        $(byText(State)).click();
        $("#city").click();
        $(byText(City)).click();
        $("#submit").click();

        $(".table-responsive tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text(Fn+' '+Ln));
        $(".table-responsive tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text(Email));
        $(".table-responsive tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text(Gender));
        $(".table-responsive tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text(Mobile));
        $(".table-responsive tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text(DayOfBirth+' '+MonthOfBirth+','+YearOfBirth));
        $(".table-responsive tbody tr:nth-child(6) td:nth-child(2)").shouldBe(empty);
        $(".table-responsive tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text(Hobby1+", "+Hobby2+", "+Hobby3));
        $(".table-responsive tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text(File));
        $(".table-responsive tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text(Addr));
        $(".table-responsive tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text(State+" "+City));

    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }
}
