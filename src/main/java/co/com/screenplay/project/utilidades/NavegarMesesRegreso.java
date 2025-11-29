package co.com.screenplay.project.utilidades;

import co.com.screenplay.project.ui.agendamiento.partidaregreso.PartidaRegresoUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarMesesRegreso implements Task {

    private final String targetMonthYear;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US);

    public NavegarMesesRegreso(String targetMonthYear) {
        this.targetMonthYear = targetMonthYear;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PartidaRegresoUi.MES_ACTUAL_VISIBLE(""), isVisible()).forNoMoreThan(10).seconds()
        );

        String currentMonthText = Text.of(PartidaRegresoUi.MES_ACTUAL_VISIBLE("")).answeredBy(actor).trim();

        YearMonth startDate = YearMonth.parse(currentMonthText, formatter);

        YearMonth targetDate = YearMonth.parse(targetMonthYear, formatter);

        long monthDifference = ChronoUnit.MONTHS.between(startDate, targetDate);

        int clicks = (int) Math.abs(monthDifference);

        Performable buttonToClick = (monthDifference > 0)
                ? Click.on(PartidaRegresoUi.BTN_SIGUIENTE_MES)
                : Click.on(PartidaRegresoUi.BTN_ANTERIOR_MES);

        for (int i = 0; i < clicks; i++) {
            actor.attemptsTo(
                    buttonToClick,
                    WaitUntil.the(PartidaRegresoUi.BTN_ANTERIOR_MES, isVisible()).forNoMoreThan(1).seconds()
            );
        }
    }

    public static NavegarMesesRegreso untilVisible(String mesYAnio) {
        return Tasks.instrumented(NavegarMesesRegreso.class, mesYAnio);
    }
}