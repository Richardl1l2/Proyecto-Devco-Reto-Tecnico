package co.com.screenplay.project.stepdefinitions.scenariodos;

import co.com.screenplay.project.preguntas.scenariodos.ScenarioDosPregunta;
import co.com.screenplay.project.tareas.scenariodos.ScenarioDosDiaTarea;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class ScenarioDosStepDefinition {

    @Y("Seleccionar el día diez del mes siguiente.")
    public void seleccionarElDiaQuinceDelMesSiguiente() {
        theActorInTheSpotlight().attemptsTo(
                ScenarioDosDiaTarea.go(),
                ImprimirFecha.ahora()
        );
    }

    @Entonces("Validar que la fecha seleccionada mes siguiente {string} aparece en el campo de texto.")
    public void validarQueLaFechaSeleccionadaApareceEnElCampoDeTexto(String diaEsperado) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ScenarioDosPregunta.value(),
                        equalTo(diaEsperado))
        );
    }
}
