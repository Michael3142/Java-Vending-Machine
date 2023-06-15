package com.techelevator.ui;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage()
    {
        System.out.println();
        System.out.println("If you would like to stop feeding, enter (Q)");
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayPurchaseScreen(){
        System.out.println();
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
//        System.out.println("Current Money Provided: " );
    }

}
