package co.com.screenplay.project.stepdefinitions.scenariouno;

import co.com.screenplay.project.preguntas.scenariouno.FechaCalendarioPregunta;
import co.com.screenplay.project.tareas.ScenarioUnoFechaTarea;
import co.com.screenplay.project.tareas.ScenarioUnoIframeTarea;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import co.com.screenplay.project.tareas.scenariouno.ScenarioUnoDiaTarea;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class RutaPrincipalStepDefinition {

    @Dado("Cambiar al iframe donde se encuentra el calendario.")
    public void cambiarAlIframeDondeSeEncuentraElCalendario() {
        theActorInTheSpotlight().attemptsTo(
                ScenarioUnoIframeTarea.go()
        );
    }

    @Cuando("Hacer click en el campo de selección de fecha.")
    public void hacerClickEnElCampoDeSeleccionDeFecha() {
        theActorInTheSpotlight().attemptsTo(
                ScenarioUnoFechaTarea.go()
        );
    }
}
