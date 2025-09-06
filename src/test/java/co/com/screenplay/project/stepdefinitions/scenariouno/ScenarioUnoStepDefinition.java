package co.com.screenplay.project.stepdefinitions.scenariouno;

import co.com.screenplay.project.preguntas.scenariouno.ScenarioUnoPregunta;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import co.com.screenplay.project.tareas.scenariouno.ScenarioUnoDiaTarea;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class ScenarioUnoStepDefinition {

    @Y("Seleccionar el día quince del mes actual.")
    public void seleccionarElDiaQuinceDelMesActual() {
        theActorInTheSpotlight().attemptsTo(
                ScenarioUnoDiaTarea.go(),
                ImprimirFecha.ahora()
        );
    }

    @Entonces("Validar que la fecha seleccionada mes actual {string} aparece en el campo de texto.")
    public void validarQueLaFechaSeleccionadaApareceEnElCampoDeTexto(String diaEsperado) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ScenarioUnoPregunta.value(),
                        equalTo(diaEsperado))
        );
    }
}
