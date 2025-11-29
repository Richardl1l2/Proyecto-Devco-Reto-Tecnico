package co.com.screenplay.project.ui.agendamiento.rangoprecio;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RangoPrecioUi {

    public static Target BTN_DESTINO = Target.the("Click sobre el boton de destino")
            .located(By.xpath("//button[normalize-space()='Select Destination']"));

    public static Target BTN_CARGAR_MAS = Target.the("Click sobre el boton cargar mas")
            .located(By.xpath("//button[normalize-space()='Load more']"));

    public static Target FIELD_PRECIO = Target.the("Click sobre el campo precio")
            .located(By.xpath("//input[@value='1800']"));

    public static final Target CAMPO_VALOR_PRECIO = Target.the("Campo de texto para ingresar valor de precio")
            .located(By.xpath("//div[contains(@class, 'theme__input___3BSW2')]//input[contains(@class, 'theme__inputElement___')]"));
}

