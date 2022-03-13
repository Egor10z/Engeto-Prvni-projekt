package com.engeto.projekt;

public class State {

    private String stateAbbreviations;
    private String nameOfState;
    private int fullVAT;
    private double reducedVAT;
    private String description;

    public State(String stateAbbreviations, String nameOfState, int fullVAT, double reducedVAT, String description) {
        this.stateAbbreviations = stateAbbreviations;
        this.nameOfState = nameOfState;
        this.fullVAT = fullVAT;
        this.reducedVAT = reducedVAT;
        this.description = description;
    }

    public String getStateAbbreviations() {
        return stateAbbreviations;
    }

    public void setStateAbbreviations(String stateAbbreviations) {
        this.stateAbbreviations = stateAbbreviations;
    }

    public String getNameOfState() {
        return nameOfState;
    }

    public void setNameOfState(String nameOfState) {
        this.nameOfState = nameOfState;
    }

    public int getFullVAT() {
        return fullVAT;
    }

    public void setFullVAT(int fullVAT) {
        this.fullVAT = fullVAT;
    }

    public double getReducedVAT() {
        return reducedVAT;
    }

    public void setReducedVAT(double reducedVAT) {
        this.reducedVAT = reducedVAT;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
