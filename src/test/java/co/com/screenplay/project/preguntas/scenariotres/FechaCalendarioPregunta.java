package co.com.screenplay.project.preguntas.scenariotres;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FechaCalendarioPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String valor = CalendarioUi.FIELD_DATAPICKER
                .resolveFor(actor)
                .getValue()
                .trim();  // Ejemplo: "09/04/2025"

        // Extraer solo el día (según el formato MM/dd/yyyy)
        String[] partes = valor.split("/");
        return partes[1].replaceFirst("^0+(?!$)", "");
        // Esto devuelve "4" en lugar de "04"
    }

    public static FechaCalendarioPregunta value() {
        return new FechaCalendarioPregunta();
    }
}
