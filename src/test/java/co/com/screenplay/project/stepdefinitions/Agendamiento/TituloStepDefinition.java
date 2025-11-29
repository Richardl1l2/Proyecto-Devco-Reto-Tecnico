package co.com.screenplay.project.stepdefinitions.Agendamiento;

import co.com.screenplay.project.preguntas.titulopregunta.TituloPregunta;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.Matchers.equalTo;

public class TituloStepDefinition {
    @Entonces("el título de la página debe ser {string}")
    public void elTítuloDeLaPáginaDebeSer(String textoEsperado) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TituloPregunta.value(),
                        equalTo(textoEsperado))
        );
    }
}
