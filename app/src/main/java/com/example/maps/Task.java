package com.example.maps;

import java.util.List;

public class Task {
    private int id ;
    private int numOfActivities ;
    private List<String> activitiesNames ;
    private String description ;

    public Task(int id, int numOfActivities, List<String> activitiesNames, String description) {
        this.id = id;
        this.numOfActivities = numOfActivities;
        this.activitiesNames = activitiesNames;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfActivities() {
        return numOfActivities;
    }

    public void setNumOfActivities(int numOfActivities) {
        this.numOfActivities = numOfActivities;
    }

    public List<String> getActivitiesNames() {
        return activitiesNames;
    }

    public void setActivitiesNames(List<String> activitiesNames) {
        this.activitiesNames = activitiesNames;
    }
}
