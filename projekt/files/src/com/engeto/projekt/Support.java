package com.engeto.projekt;

import java.util.Scanner;

    import java.util.Scanner;

    public class Support {

        private static Scanner scanner = null;
        private static Scanner getScanner() {
            if (scanner == null) {
                scanner = new Scanner(System.in);
            }
            return scanner;
        }

        public static int INVALID_INPUT = -1;

        public static double safeReadDouble() throws StateException {
            double autoFill = 20;
            double result = INVALID_INPUT;
            System.out.print("Filtr sazby: ");
            String inputText = getScanner().nextLine();
            try {
                result = Double.parseDouble(inputText);
            } catch (NumberFormatException ex) {
                if(!inputText.isEmpty())
                System.err.println("Chybně zadané číslo");
            }
            if (inputText.isEmpty()){
                return autoFill;
            }
            if (result < 0){
                throw new StateException("Číslo nemůže být záporné!");
            }
            return result;
        }

    }
