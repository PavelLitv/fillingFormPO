package guru.qa.pageobject.pages.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy", Locale.ENGLISH);
        String strDate = formatter.format(date);
        String[] dates = strDate.split(" ");

        $(".react-datepicker__month-select").selectOption(dates[1]);
        $(".react-datepicker__year-select").selectOption(dates[2]);
        $(".react-datepicker__day--0" + dates[0] +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
