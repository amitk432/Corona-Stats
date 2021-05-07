package com.example.corona;

public class ModelClass {

    String region ;
    String activeCases ;
    String newInfected ;
    String recovered ;
    String newRecovered ;
    String deceased ;
    String newDeceased ;
    String totalInfected ;


    public ModelClass(String region, String activeCases, String newInfected, String recovered, String newRecovered, String deceased, String newDeceased, String totalInfected) {
        this.region = region;
        this.activeCases = activeCases;
        this.newInfected = newInfected;
        this.recovered = recovered;
        this.newRecovered = newRecovered;
        this.deceased = deceased;
        this.newDeceased = newDeceased;
        this.totalInfected = totalInfected;
    }

    public ModelClass() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getNewInfected() {
        return newInfected;
    }

    public void setNewInfected(String newInfected) {
        this.newInfected = newInfected;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getNewDeceased() {
        return newDeceased;
    }

    public void setNewDeceased(String newDeceased) {
        this.newDeceased = newDeceased;
    }

    public String getTotalInfected() {
        return totalInfected;
    }

    public void setTotalInfected(String totalInfected) {
        this.totalInfected = totalInfected;
    }


}
