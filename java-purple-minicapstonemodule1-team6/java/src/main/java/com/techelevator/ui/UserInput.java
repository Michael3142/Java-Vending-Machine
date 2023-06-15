package com.techelevator.ui;

import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.println("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D")) {
            return "display";
        } else if (option.equals("P")) {
            return "purchase";
        } else if (option.equals("E")) {
            return "exit";
        } else {
            return "";
        }

    }

    public static String getScreenChoice() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("M")) {
            return "Money";
        } else if (input.equalsIgnoreCase("S")) {
            return "Select item";

        } else if (input.equalsIgnoreCase("F")) {
            return "Finish Transaction";
        } else {
            return "";
        }
    }
//    public String getSlot() {
//        String input = scanner.nextLine();
//
//
//
//
//    }


        public static String promptForMoney () {

            System.out.println("How much to feed in?");
            String input = scanner.nextLine();

            return input;

        }

        public static String returnToPurchaseScreen () {

            String input = scanner.nextLine();
            return input;
        }


        public static String getSlot() {
            String input = scanner.nextLine();
            return input;
        }

    }



