package co.com.screenplay.project.utilidades;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class wait{
    public static Performable waitForMilliseconds(int milliseconds) {
        return Task.where(
                actor -> {
                    try {
                        Thread.sleep(milliseconds);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
