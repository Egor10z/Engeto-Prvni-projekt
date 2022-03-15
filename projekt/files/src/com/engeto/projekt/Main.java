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
    //1.
        //  for (State state : states.getAllStates()) {
        //System.out.println(state.getStateInfo());
        //
        //}
    //2.
        states.getAllStates20Vat();


    //.3
            

    }}





