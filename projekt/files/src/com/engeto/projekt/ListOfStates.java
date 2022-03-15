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

    String oldContent = ",";

    public void importStatesFromFile(String filename) throws StateException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {

            int line = 0;
            while (scanner.hasNextLine()) {
                String order = scanner.nextLine();
                String order2 = order.replace(",", ".");
                line++;
                try {
                    this.addState(State.parseState(order2, DELIMITER));
                } catch (StateException e) {
                    throw new StateException("Chybný soubor na řádku: " +line+ "->" + e.getLocalizedMessage());
                }

            }
        } catch (FileNotFoundException e) {
            throw new StateException("Vstupní soubor " +filename+ " nebyl nalezen: " +e.getLocalizedMessage());
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

