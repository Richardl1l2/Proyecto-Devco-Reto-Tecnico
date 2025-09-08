package co.com.screenplay.project.tareas.scenariouno;


import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ImprimirFecha implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String fecha = CalendarioUi.FIELD_DATAPICKER.resolveFor(actor).getValue();
        System.out.println("📅 La fecha en el campo datepicker es: " + fecha);
    }

    public static ImprimirFecha ahora() {
        return Instrumented.instanceOf(ImprimirFecha.class).withProperties();
    }
}