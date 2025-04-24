package model;
import java.io.Serializable;

public class Driver implements Serializable {
    private String id;
    private String name;
    private String assignedVehicle;
    private String status;

    public Driver(String id, String name, String assignedVehicle, String status) {
        this.id = id;
        this.name = name;
        this.assignedVehicle = assignedVehicle;
        this.status = status;
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

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
