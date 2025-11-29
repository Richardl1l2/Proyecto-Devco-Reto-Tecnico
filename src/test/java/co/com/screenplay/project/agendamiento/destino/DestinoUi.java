package co.com.screenplay.project.agendamiento.destino;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DestinoUi {

    public static Target BTN_UBICACION_VIAJE = Target.the("Click sobre el boton ubicacion viaje")
            .located(By.xpath("//input[@value='Launch']"));

    public static Target ELEMENTO_LISTA_DINAMICO(String nombreLista) {

        // El XPath busca cualquier <li> cuyo texto sea exactamente igual al nombre.
        // Se usa normalize-space() para ignorar espacios extra si los hay.
        String xpathDinamico = "//li[normalize-space()='" + nombreLista + "']";

        return Target.the("Elemento de lista: " + nombreLista)
                .located(By.xpath(xpathDinamico));
    }

    public static Target BTN_BOOK = Target.the("Click sobre boton Book")
            .located(By.xpath("//div[@class='Box__box___2XzJ2 Gallery__items-box___2hOZl']//div[1]//div[4]//button[1]"));


}

