package co.com.screenplay.project.tareas.scenariotres;

import co.com.screenplay.project.utilidades.DiaAleatorio;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarFechaCalendarioTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DiaAleatorio.seleccionarDiaAleatorio())
        );
    }
    public static SeleccionarFechaCalendarioTarea go() {
        return Instrumented.instanceOf(SeleccionarFechaCalendarioTarea.class).withProperties();
    }
}
