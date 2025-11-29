package co.com.screenplay.project.utilidades;
import co.com.screenplay.project.agendamiento.partidaregreso.PartidaRegresoUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.time.temporal.ChronoUnit;

public class NavegarMesesPartida implements Task {

    private final String targetMonthYear;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US);

    public NavegarMesesPartida(String targetMonthYear) {
        this.targetMonthYear = targetMonthYear;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        YearMonth today = YearMonth.from(LocalDate.now());

        YearMonth targetDate = YearMonth.parse(targetMonthYear, formatter);

        long monthDifference = ChronoUnit.MONTHS.between(today, targetDate);

        int clicks = (int) Math.abs(monthDifference);

        Performable buttonToClick = (monthDifference > 0)
                ? Click.on(PartidaRegresoUi.BTN_SIGUIENTE_MES)
                : Click.on(PartidaRegresoUi.BTN_ANTERIOR_MES);

        actor.attemptsTo(
                WaitUntil.the(PartidaRegresoUi.MES_ACTUAL_VISIBLE(""), isVisible()).forNoMoreThan(10).seconds()
        );

        for (int i = 0; i < clicks; i++) {
            actor.attemptsTo(
                    buttonToClick,
                    WaitUntil.the(PartidaRegresoUi.BTN_ANTERIOR_MES, isVisible()).forNoMoreThan(1).seconds()
            );
        }
    }

    public static NavegarMesesPartida untilVisible(String mesYAnio) {
        return Tasks.instrumented(NavegarMesesPartida.class, mesYAnio);
    }
}