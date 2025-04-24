package test;

import controller.Sgmms;
import model.Incident;
import model.Route;
import org.junit.jupiter.api.Test;
import structures.LinkedList;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SgmmsTest {
    private Sgmms system;
    private LinkedList<Route> routes;
    private LinkedList<Incident> incidents;

    public void setUp() {
        system = new Sgmms();
    }

    @Test
    void testSearchRouteById_Positive() {
        Route route = new Route("R1", 120, 2, "Ciudad C", "Ciudad D");
        system.addRoute(route);

        Route found = system.searchRouteById("R1");

        assertNotNull(String.valueOf(found), "La ruta debería existir");
        assertEquals("R1", found.getId(), "El ID de la ruta encontrada debe coincidir");
    }

    @Test
    void testSearchRouteById_Negative() {
        Route found = system.searchRouteById("R999");
        assertNull(found, "La ruta no debería existir");
    }

}
