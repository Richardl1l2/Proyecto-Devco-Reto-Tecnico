package co.com.screenplay.project.preguntas.compra;

import co.com.screenplay.project.ui.agendamiento.resumenpago.ResumenPagoUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CompraPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ResumenPagoUi.TXT_VALIDAR, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return ResumenPagoUi.TXT_VALIDAR.resolveFor(actor).getText();
    }

    public static CompraPregunta value() {
        return new CompraPregunta();
    }
}
