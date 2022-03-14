package com.engeto.projekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfStates {

    private static final String DELIMITER = "\t";

    List<State> listOfStates = new ArrayList<>();

    public void addState(State state) {
        listOfStates.add(state);
    }

    public State getState(int index) {
        return listOfStates.get(index);
    }

    public void removeState(int index) {
        listOfStates.remove(index);
    }

    public void importStatesFromFile(String filename) throws StateException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                String order = scanner.nextLine();
                i++;
                try {
                    this.addState(State.parseState(order, DELIMITER));
                } catch (StateException e) {
                    throw new StateException("Neplatný soubor");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<State> getAllStates() {
        return new ArrayList<>(listOfStates);
    }
    public void getAllStates20Vat() {
        for(State state : listOfStates) {
            if (state.getFullVAT() > 20) {
                System.out.println(state.getStateInfo());
            }
    }

}}

