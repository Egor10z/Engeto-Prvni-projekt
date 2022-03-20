package com.engeto.projekt;

import java.io.*;
import java.util.*;

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
        for (State state : listOfStates) {
            if (state.getFullVAT() > 20 && !state.specialVAT) {
                System.out.println(state.getStateInfo());
            }
        }


    }

    public void getAllStates20VatSort() {
        Collections.sort(listOfStates);
        for (State state : listOfStates) {
            if (state.getFullVAT() > 20 && !state.specialVAT) {
                System.out.println(state.getStateInfo());
            }
        }
        System.out.println("====================");
        System.out.print("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        for (State state : listOfStates) {
            if (state.getFullVAT() <= 20){
                if (state.specialVAT = true){
                    System.out.print(state.getStateAbbreviations() + ", ");
                }

            }
        }
    }




    public void saveToFile(String output) throws StateException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {

            Collections.sort(listOfStates);
            for (State state : listOfStates) {
                if (state.getFullVAT() > 20 && !state.specialVAT) {
                    writer.println(state.getStateInfo());
                }
            }
            writer.println("====================");
            writer.print("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
            for (State state : listOfStates) {
                if (state.getFullVAT() <= 20) {
                    if (state.specialVAT = true) {
                        writer.print(state.getStateAbbreviations() + ", ");
                    }
                }

            }


        } catch (IOException e) {
            throw new StateException("Soubor nelze uložit do: " +output+ ": " +e.getLocalizedMessage());

        }
    }


    public void saveFilteredFiles() throws StateException {

        int input = (int) Support.safeReadDouble();
            try (PrintWriter writer = new PrintWriter(new FileWriter(("files/src/vat-over-" + input+".txt")))) {

                for (State state : listOfStates) {
                    if (input < state.getFullVAT()) {
                        writer.println(state.getStateInfo());
                    }
                }
                writer.println("====================");
                writer.print("Zbytek států se sazbou menší než "+input+"% : ");
                for (State state : listOfStates) {
                    if (state.getFullVAT() < input) {
                            writer.print(state.getStateAbbreviations() + ", ");
            }
        }
        } catch (IOException e) {
                e.getLocalizedMessage();
            }
    }
}

