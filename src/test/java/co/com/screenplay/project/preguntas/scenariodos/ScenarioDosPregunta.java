package co.com.screenplay.project.preguntas.scenariouno;

import co.com.screenplay.project.ui.scenariouno.ScenarioUnoUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ScenarioUnoPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ScenarioUnoUi.FIELD_DATAPICKER, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return ScenarioUnoUi.FIELD_DATAPICKER.resolveFor(actor).getValue();
    }

    public static ScenarioUnoPregunta value() {
        return new ScenarioUnoPregunta();
    }
}