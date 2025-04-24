package controller;

import com.google.gson.JsonObject;
import model.*;
import structures.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import structures.Node;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sgmms {
    private LinkedList<Route> routes;
    private LinkedList<Incident> incidents;
    private LinkedList<Passenger> passengers;
    private LinkedList<Driver> drivers;

    private static final String ROUTES_FILE = "routes.json";
    private static final String INCIDENTS_FILE = "incidents.json";
    private static final String PASSENGERS_FILE = "passengers.json";
    private static final String DRIVERS_FILE = "drivers.json";

    private File data;
    private Path dataFolder;
    private Path dataJson;

    public Sgmms() {
        this.routes = new LinkedList<>();
        this.incidents = new LinkedList<>();
        this.passengers = new LinkedList<>();
        this.drivers = new LinkedList<>();

        loadRoutes();
        loadIncidents();
        loadPassengers();
        loadDrivers();
    }

    /* Gestión de Rutas */

    public void addRoute(Route route) {
        routes.add(route);
        saveRoutes();
    }

    public LinkedList<Route> getRoutes() {
        return routes;
    }

    public Route searchRouteById(String id) {
        return routes.search(r -> r != null && r.getId().equals(id));
    }

    public void addIncidentToRoute(String routeId, Incident incident) {
        Route route = searchRouteById(routeId);
        if (route != null) {
            route.addIncident(incident);
            saveIncidents();
        } else {
            System.out.println("Ruta no encontrada. No se puede agregar el incidente.");
        }
    }

    /* Gestión de Conductores */

    public void addDriver(Driver driver) {
        if (drivers.search(d -> d.getId().equals(driver.getId())) != null) {
            System.out.println("Error: Ya existe un conductor con ID " + driver.getId());
            return;
        }
        drivers.add(driver);
        saveDrivers();
        System.out.println("Conductor agregado: " + driver.getName());
    }

    public Driver searchDriverById(String id) {
        return drivers.search(d -> d.getId().equals(id));
    }

    public void assignDriverToVehicle(String driverId, String vehicleId) {
        Driver driver = searchDriverById(driverId);
        if (driver != null) {
            driver.setAssignedVehicle(vehicleId);
            saveDrivers();
            System.out.println("Conductor " + driver.getName() + " asignado al vehículo " + vehicleId);
        } else System.out.println("Conductor no encontrado");
    }

    public void assignDriverToRoute(String driverId, String routeId) {
        Driver driver = searchDriverById(driverId);
        Route route = searchRouteById(routeId);
        if (driver != null && route != null) {
            driver.setStatus("Asignado a la ruta " + route.getId());
            saveDrivers();
            System.out.println("Conductor " + driver.getName() + " asignado a la ruta " + route.getId());
        } else System.out.println("Conductor o ruta no encontrados");
    }

    public void listAllDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("No hay conductores registrados.");
            return;
        }
        drivers.forEach(driver -> {System.out.println("ID: " + driver.getId() + " | Nombre: " + driver.getName()
                + " | Vehículo: " + driver.getAssignedVehicle() + " | Estado: " + driver.getStatus());
        });
    }

    /* Gestión de Incidentes */

    public LinkedList<Incident> getIncidentsByRouteId(String routeId) {
        Route route = searchRouteById(routeId);
        return (route != null) ? route.getIncidents() : new LinkedList<>();
    }

    /* Métodos de búsqueda */

    public Incident searchIncidentById(String id) {
        return incidents.search(i -> i.getId().equals(id));
    }

    public LinkedList<Driver> searchDriversByName(String name) {
        LinkedList<Driver> result = new LinkedList<>();
        drivers.forEach(driver -> {
            if (driver.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(driver);
            }
        });
        return result;
    }

    public Route findBestRoute() {
        return routes.isEmpty() ? null : routes.min((r1, r2) -> Double.compare(r1.getDistance(), r2.getDistance()));
    }

    /* Reportes */

    public void reportRoutesSortedByDistance() {
        routes.sort(Comparator.comparingDouble(Route::getDistance));
        System.out.println("Rutas ordenadas por distancia:");
        routes.forEach(System.out::println);
    }

    public void reportRoutesSortedByTime() {
        routes.sort(Comparator.comparingInt(Route::getEstimatedTime));
        System.out.println("Rutas ordenadas por tiempo estimado:");
        routes.forEach(System.out::println);
    }

    public void reportIncidentsSortedByDate() {
        incidents.sort(Comparator.comparing(Incident::getDateHour).reversed());
        System.out.println("Incidentes ordenados por fecha/hora:");
        incidents.forEach(System.out::println);
    }

    public void reportSearchResults(String incidentId, String driverName) {
        System.out.println("Resultados de búsqueda:");
        System.out.println("Incidente encontrado: " + searchIncidentById(incidentId));
        System.out.println("Conductores encontrados: ");
        searchDriversByName(driverName).forEach(System.out::println);
    }

    public void reportBestRoute() {
        Route bestRoute = findBestRoute();
        System.out.println("Mejor ruta encontrada: " + (bestRoute != null ? bestRoute : "No hay rutas disponibles"));
    }

    /** Métodos de ordenamiento */

    public void sortRoutesByDistance() {
        routes.sort(Comparator.comparingDouble(Route::getDistance));
    }

    public void sortRoutesByTime() {
        routes.sort(Comparator.comparingInt(Route::getEstimatedTime));
    }

    public void sortIncidentsByDate() {
        incidents.sort(Comparator.comparing(Incident::getDateHour).reversed());
    }

    /** Gestión de JSON */

    private <T> void loadJson(String filename, Type type, LinkedList<T> list) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        try (Reader reader = new FileReader(filename)) {
            List<T> data = gson.fromJson(reader, new TypeToken<List<T>>() {}.getType());
            if (data != null) {
                list.clear();
                for (T item : data) {
                    list.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar " + filename + ": " + e.getMessage());
        }
    }

    public void saveData (String filename, Object data){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(data, writer);
            System.out.println("Datos guardados exitosamente en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRoutes() {
        saveData(ROUTES_FILE, routes);
    }

    public void saveIncidents() {
        saveData(INCIDENTS_FILE, incidents);
    }

    public void savePassengers() {
        saveData(PASSENGERS_FILE, passengers);
    }

    public void saveDrivers() {
        saveData(DRIVERS_FILE, drivers);
    }

    public void loadRoutes() {
        loadJson(ROUTES_FILE, new TypeToken<LinkedList<Route>>() {}.getType(), routes);
    }

    public void loadIncidents() {
        loadJson(INCIDENTS_FILE, new TypeToken<LinkedList<Incident>>() {}.getType(), incidents);
    }

    public void loadPassengers() {
        loadJson(PASSENGERS_FILE, new TypeToken<LinkedList<Passenger>>() {}.getType(), passengers);
    }

    public void loadDrivers() {
        loadJson(DRIVERS_FILE, new TypeToken<LinkedList<Driver>>() {}.getType(), drivers);
    }
}

