package co.com.screenplay.project.preguntas.scenariotres;

import co.com.screenplay.project.ui.scenariouno.ScenarioUnoUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class FechaCalendarioPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return ScenarioUnoUi.FIELD_DATAPICKER
                .resolveFor(actor)
                .getValue()   // <-- este trae lo escrito o seleccionado en el input
                .trim();
    }

    public static FechaCalendarioPregunta value() {
        return new FechaCalendarioPregunta();
    }
}

