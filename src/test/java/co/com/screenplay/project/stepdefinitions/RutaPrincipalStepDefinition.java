package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.tareas.DatapickerFechaTarea;
import co.com.screenplay.project.tareas.IframeTarea;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class RutaPrincipalStepDefinition {

    @Dado("Cambiar al iframe donde se encuentra el calendario.")
    public void cambiarAlIframeDondeSeEncuentraElCalendario() {
        theActorInTheSpotlight().attemptsTo(
                IframeTarea.go()
        );
    }

    @Cuando("Hacer click en el campo de selección de fecha.")
    public void hacerClickEnElCampoDeSeleccionDeFecha() {
        theActorInTheSpotlight().attemptsTo(
                DatapickerFechaTarea.go()
        );
    }
}
