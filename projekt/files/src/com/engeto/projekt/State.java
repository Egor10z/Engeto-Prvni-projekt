package com.engeto.projekt;

public class State {

     String stateAbbreviations;
     String nameOfState;
     Double fullVAT;
     Double reducedVAT;
     boolean specialVAT;

    public State(String stateAbbreviations, String nameOfState, Double fullVAT, Double reducedVAT, boolean specialVAT) {
        this.stateAbbreviations = stateAbbreviations;
        this.nameOfState = nameOfState;
        this.fullVAT = fullVAT;
        this.reducedVAT = reducedVAT;
        this. specialVAT = specialVAT;
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

    public Double getFullVAT() {
        return fullVAT;
    }

    public void setFullVAT(Double fullVAT) {
        this.fullVAT = fullVAT;
    }

    public double getReducedVAT() {
        return reducedVAT;
    }

    public void setReducedVAT(double reducedVAT) {
        this.reducedVAT = reducedVAT;
    }

    public boolean getDescription() {
        return specialVAT;
    }

    public void setDescription(boolean specialVAT) {
        this.specialVAT = specialVAT;
    }
}
