package model;
import java.io.Serializable;

public class Passenger implements Serializable{
    private String id;
    private String name;
    private String assignedRoute;
    private String contact;

    public Passenger(String id, String name, String assignedRoute, String contact) {
        this.id = id;
        this.name = name;
        this.assignedRoute = assignedRoute;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignedRoute() {
        return assignedRoute;
    }

    public void setAssignedRoute(String assignedRoute) {
        this.assignedRoute = assignedRoute;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
