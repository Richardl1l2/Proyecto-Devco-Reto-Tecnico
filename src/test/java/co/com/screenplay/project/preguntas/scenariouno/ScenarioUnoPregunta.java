package co.com.screenplay.project.preguntas.scenariouno;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ScenarioUnoPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(CalendarioUi.FIELD_DATAPICKER, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return CalendarioUi.FIELD_DATAPICKER.resolveFor(actor).getValue();
    }

    public static ScenarioUnoPregunta value() {
        return new ScenarioUnoPregunta();
    }
}