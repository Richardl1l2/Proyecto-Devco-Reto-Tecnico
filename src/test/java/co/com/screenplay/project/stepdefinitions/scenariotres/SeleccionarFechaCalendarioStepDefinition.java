package co.com.screenplay.project.stepdefinitions.scenariotres;

import co.com.screenplay.project.preguntas.scenariodos.ScenarioDosPregunta;
import co.com.screenplay.project.preguntas.scenariotres.CampoDatepickerAceptaManualPregunta;
import co.com.screenplay.project.tareas.scenariodos.ScenarioDosDiaTarea;
import co.com.screenplay.project.tareas.scenariotres.ScenarioTresTarea;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class ScenarioTresStepDefinition {
    @Cuando("Intentar ingresar una fecha {string} manualmente en el campo de texto.")
    public void intentarIngresarUnaFechaManualmenteEnElCampoDeTexto(String fechaManual) {
        theActorInTheSpotlight().attemptsTo(
                ScenarioTresTarea.go(fechaManual),
                ImprimirFecha.ahora()
        );
    }

    @Entonces("Validar que no se permite la edición manual y que solo es posible seleccionar una fecha desde el calendario.")
    public void validarQueNoSePermiteLaEdicionManualYQueSoloEsPosibleSeleccionarUnaFechaDesdeElCalendario() {
        String fechaPrueba = "12/24/2025"; // valor ingresado manualmente

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        CampoDatepickerAceptaManualPregunta.conValor(fechaPrueba),
                        equalTo("✅ Correcto: el campo no permite la edición manual.")
                )
        );
    }
}
