package com.engeto.projekt;


public class Main {
    public static final String FILENAME = "vat-eu.csv";


    public static void main(String[] args) {

        ListOfStates listOfStates = new ListOfStates();
         try {
             listOfStates.importStatesFromFile(FILENAME);
         } catch (StateException e) {
             e.printStackTrace();
         }

    }
}
