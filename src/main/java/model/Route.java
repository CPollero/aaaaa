package model;
import structures.LinkedList;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable, Comparable<Route>{
    private String id;
    private double distance;
    private int estimatedTime;
    private String startPoint;
    private String endPoint;
    private LinkedList<Incident> incidents;

    public Route (String id, double distance, int estimatedTime, String startPoint, String endPoint) {
        this.id = id;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public String getId() {
        return id;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) { this.distance = distance; }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public int compareTo(Route other) {
        return Double.compare(this.distance, other.distance);
    }

    public LinkedList<Incident> getIncidents() {
        return incidents;
    }

    public void addIncident(Incident incident) {
        incidents.add(incident);
    }
}
