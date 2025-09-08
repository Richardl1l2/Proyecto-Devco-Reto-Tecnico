package co.com.screenplay.project.utilidades;

import net.serenitybdd.screenplay.targets.Target;

import java.time.LocalDate;
import java.util.Random;

public class DiaAleatorio {

    private static final Random random = new Random();
    private static int ultimoDiaGenerado; // guardamos el último día generado

    public static Target seleccionarDiaAleatorio() {
        LocalDate fechaActual = LocalDate.now();
        int diasDelMes = fechaActual.lengthOfMonth();

        ultimoDiaGenerado = random.nextInt(diasDelMes) + 1;

        String xpathDia = String.format("//a[normalize-space()='%d']", ultimoDiaGenerado);

        return Target.the("Seleccionar el día aleatorio " + ultimoDiaGenerado)
                .locatedBy(xpathDia);
    }

    public static String getUltimoDiaGenerado() {
        // para que lo compares luego con el campo FIELD_DATAPICKER
        return String.valueOf(ultimoDiaGenerado);
    }
}
