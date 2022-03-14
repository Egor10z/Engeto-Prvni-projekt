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


    public static State parseState(String text,String delimiter) throws StateException{
        String[] parts = text.split(delimiter);

        String stateAbbreviations = parts[0];
        String nameOfState = parts [1];
        try {
            Double fullVAT = Double.parseDouble(parts[2]);
            Double reducedVAT = Double.parseDouble(parts[3]);
            boolean specialVAT;
            if (parts[4].equals("true")){
                specialVAT = true;
            }
            else if (parts[4].equals("false")){
                specialVAT = false;
            }
            else{
                throw new StateException("Chybně zadaná hodnota pro specální sazby");
            }
            return new State(stateAbbreviations,nameOfState,fullVAT,reducedVAT,specialVAT);
        } catch (NumberFormatException ex){
            throw new StateException("Špatně zadané údaje");
        }

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

    public String getStateInfo() {
        return "Název země: " + nameOfState + "(zkratka): " +stateAbbreviations+ " zakladní sazba " + fullVAT+ "%";
    }
}
