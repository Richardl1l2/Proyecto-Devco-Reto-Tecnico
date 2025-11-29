package co.com.screenplay.project.ui.agendamiento.resumenpago;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResumenPagoUi {

    public static Target FIELD_CODIGO_PROMO = Target.the("Click sobre el campo codigo promocional")
            .located(By.xpath("//input[@name='promo']"));

    public static Target BTN_APLICAR = Target.the("Click sobre el boton aplicar")
            .located(By.xpath("//button[normalize-space()='Apply']"));

    public static Target CHECKBOX_TERMINOS_CONDICIONES = Target.the("Marcar checbox de terminos y condiciones")
            .located(By.xpath("//div[@class='theme__check___2B20W']"));

    public static final Target BTN_PAY_NOW = Target.the("Boton Pay now")
            .located(By.xpath("//button[normalize-space()='Pay now']"));

    public static Target TXT_VALIDAR = Target.the("Validacion")
            .located(By.xpath("//div[@class='supuesto']"));
}

