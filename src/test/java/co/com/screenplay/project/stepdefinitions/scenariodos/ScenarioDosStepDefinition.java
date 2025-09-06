package co.com.screenplay.project.stepdefinitions.scenariouno;

import co.com.screenplay.project.preguntas.scenariouno.FechaCalendarioPregunta;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import co.com.screenplay.project.tareas.scenariouno.ScenarioUnoDiaTarea;
import co.com.screenplay.project.tareas.ScenarioUnoFechaTarea;
import co.com.screenplay.project.tareas.ScenarioUnoIframeTarea;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ScenarioUnoStepDefinition {

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
                        FechaCalendarioPregunta.value(),
                        equalTo(diaEsperado))
        );
    }
}
