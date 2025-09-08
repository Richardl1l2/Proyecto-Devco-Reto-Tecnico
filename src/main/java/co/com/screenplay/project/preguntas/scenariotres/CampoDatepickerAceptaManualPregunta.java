package co.com.screenplay.project.preguntas.scenariotres;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CampoDatepickerAceptaManualPregunta implements Question<String> {

    private final String fechaManual;

    public CampoDatepickerAceptaManualPregunta(String fechaManual) {
        this.fechaManual = fechaManual;
    }

    @Override
    public String answeredBy(Actor actor) {
        String valorCampo = CalendarioUi.FIELD_DATAPICKER.resolveFor(actor).getValue();

        if (valorCampo != null && valorCampo.equals(fechaManual)) {
            return "Error: el campo aceptó la edición manual.";
        }
        return "Correcto: el campo no permite la edición manual.";
    }

    public static CampoDatepickerAceptaManualPregunta conValor(String fechaManual) {
        return new CampoDatepickerAceptaManualPregunta(fechaManual);
    }
}
