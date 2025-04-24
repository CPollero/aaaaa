package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Incident implements Serializable, Comparable<Incident> {
    private String id;
    private String type;
    private String location;
    private LocalDateTime DateHour;
    private String description;
    private String status;

    public Incident (String id, String type, String location, LocalDateTime DateHour, String description, String status) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.DateHour = DateHour;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateHour() {
        return DateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        DateHour = dateHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Incident other) {
        return this.DateHour.compareTo(other.DateHour);
    }
}
