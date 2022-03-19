package com.engeto.projekt;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;

import static com.engeto.projekt.Support.safeReadDouble;

public class Main {
    public static final String FILENAME = "vat-eu.csv";
    public static final String OUTPUT = "vat-eu-20.txt";


        public static void main(String[] args) throws StateException {

            ListOfStates states = new ListOfStates();
            try {
                states.importStatesFromFile(FILENAME);
            } catch (StateException e) {
                e.printStackTrace();
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
                ex.printStackTrace();
            }
            */
            // 7.
             states.readVatInput();
            }
        }
