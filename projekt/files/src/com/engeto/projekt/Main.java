package com.engeto.projekt;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILENAME = "vat-eu.csv";


    public static void main(String[] args) {

        ListOfStates states = new ListOfStates();
         try {
             states.importStatesFromFile(FILENAME);
         } catch (StateException e) {
             e.printStackTrace();
         }

         for (State state : states.getAllStates()) {
             System.out.println(state.getStateInfo());
         }
         }

    }

