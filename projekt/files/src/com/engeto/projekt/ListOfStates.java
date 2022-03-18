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




    public void saveToFile(String output) {
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
            e.printStackTrace();
        }
    }





    public double safeReadInt() throws StateException{
        Scanner scanner = new Scanner(System.in);
        double autoFill = 20.0;
        double result ;
        System.out.print("Filtr sazby: ");
        String inputText = scanner.nextLine();
        try {
            result = Double.parseDouble(inputText);
        } catch (NumberFormatException ex) {
            throw new StateException("Špatně zadané číslo!");
        }
        if(inputText.isEmpty()) {
            return autoFill;
        }
            if (result < 0) {
                throw new StateException("Číslo nemůže být záporné!");
            }
            return result; }
}



