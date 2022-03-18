package com.engeto.projekt;


import java.util.*;
import java.util.Scanner;

public class Main {
    public static final String FILENAME = "vat-eu.csv";
    public static final String OUTPUT = "vat-eu-20.txt";


    public static void main(String[] args) {

        ListOfStates states = new ListOfStates();
        try {
            states.importStatesFromFile(FILENAME);
        } catch (StateException e) {
            e.printStackTrace();
        }
        //1.
        //  for (State state : states.getAllStates()) {
        //System.out.println(state.getStateInfo());
        //
        //}
        //2.
        //  states.getAllStates20Vat();

        //.3
       // states.getAllStates20VatSort();

       /* try {
            states.saveToFile(OUTPUT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/


        try {
            states.safeReadInt();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }


}






