package guru.qa.pageobject.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate(String date) {
        String[] forNumber = date.split(" ");
        String[] dates = forNumber[1].split(",");

        $(".react-datepicker__month-select").selectOption(dates[0].trim());
        $(".react-datepicker__year-select").selectOption(dates[1]);
        $(".react-datepicker__day--0" + forNumber[0] +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
