import java.util.*;
import controller.Sgmms;
import model.Route;

public class Main {
    public static void main(String[] args) {
        Sgmms system = new Sgmms();

        Route ruta1 = new Route("R1", 120, 2, "Ciudad C", "Ciudad D");
        Route ruta2 = new Route("R2", 130, 2,"Ciudad A", "Ciudad B");

        system.addRoute(ruta1);
        system.addRoute(ruta2);

        Route found = system.searchRouteById("R2");
        if (found != null) {
            System.out.println("Ruta encontrada: " + found.getId() + " de " + found.getDistance() + " a " + found.getEndPoint());
        } else {
            System.out.println("Ruta no encontrada.");
        }
    }
}
