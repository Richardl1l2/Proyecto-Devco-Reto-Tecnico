package co.com.screenplay.project.tareas;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;

public class IframeTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(CalendarioUi.IFRAME_CALENDARIO.resolveFor(actor))
        );
    }
    public static IframeTarea go() {
        return Instrumented.instanceOf(IframeTarea.class).withProperties();
    }
}
