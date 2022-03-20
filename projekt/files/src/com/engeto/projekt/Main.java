package com.engeto.projekt;


public class Main {
    public static final String FILENAME = "files/src/vat-eu.csv";
    public static final String OUTPUT = "files/src/vat-eu-20.txt";


        public static void main(String[] args) throws StateException {

            ListOfStates states = new ListOfStates();
            try {
                states.importStatesFromFile(FILENAME);
            } catch (StateException e) {
                System.err.println(e.getLocalizedMessage());
            }
            // bod 2.
             // for (State state : states.getAllStates()) {
           // System.out.println(state.getStateInfo());
            //}


            // bod 3.
            //  states.getAllStates20Vat();

            // bod 4, 5, 6
            /*states.getAllStates20VatSort();

            try {
                states.saveToFile(OUTPUT);
            } catch (Exception ex) {
                throw new StateException("Chyba při ukládání souboru");
            }*/

            // 7.
             states.saveFilteredFiles();
            }
        }
