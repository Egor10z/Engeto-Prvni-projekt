package com.engeto.projekt;

import java.util.ArrayList;
import java.util.List;

public class ListOfStates {

    private static final String DELIMITER = "\t";

    List<State> ListOfStates = new ArrayList<>();

    public void addCountry(State state) {
        ListOfStates.add(state);
    }

    public State getState(int index) {
        return ListOfStates.get(index);
    }

    public void removeState(int index) {
        ListOfStates.remove(index);
    }


}
