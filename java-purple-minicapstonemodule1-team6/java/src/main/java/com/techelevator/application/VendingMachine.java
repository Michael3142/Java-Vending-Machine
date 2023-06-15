package com.techelevator.application;

import com.techelevator.controller.ReadDataFile;
import com.techelevator.models.Goods;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class VendingMachine {

    private final String FILE_NAME = "Catering.csv";
    private final String FILE_NAME1 = "Catering1.csv";


    ReadDataFile fileInput = new ReadDataFile();
    Map<String, Goods> goods = fileInput.loadFile(FILE_NAME);
    BigDecimal balance = new BigDecimal("0.00");
    File auditFile = new File("Audit.txt");
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    String formattedDate = date.format(formatter);


    public void run() {
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();


            if (choice.equals("display")) {
                for (Map.Entry<String, Goods> vendingGoods : goods.entrySet()) {
                    Goods currentItem = vendingGoods.getValue();
                    System.out.println(currentItem.getName() + " || price of item: $" + currentItem.getPrice() + " || " + currentItem.getType() + " || quantity of items: " + vendingGoods.getValue().getQuantity());
                }

                // display the vending machine slots
            } else if (choice.equals("purchase")) {

                handlePurchaseMenuOptions();



                UserOutput.displayPurchaseScreen();


            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void handlePurchaseMenuOptions() {
        int counter = 0;

        boolean stay = true;
        do {
            UserOutput.displayPurchaseScreen();
            String purchaseChoice = UserInput.getScreenChoice();

            // if purchaseChoice is feed money
            // prompt the user for feed money stuff
            if (purchaseChoice.equalsIgnoreCase("Money")) {
                String moneyAmount = UserInput.promptForMoney();
                int newMoneyAmount = Integer.parseInt(moneyAmount);
                BigDecimal moneyAddedToBalance = BigDecimal.valueOf(newMoneyAmount);// initialize balance as BigDecimal
                balance = balance.add(moneyAddedToBalance);

                try(PrintWriter writer = new PrintWriter(new FileOutputStream(auditFile, true));) {
                    writer.println(formattedDate + "" + LocalTime.now() + "Money Fed " + balance);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Current balance = " + balance);

                // BUT if purchaseChoice is back, or quit
                // set the stay flag to false;

            } else if (purchaseChoice.equalsIgnoreCase("Select item")) {

                for (Map.Entry<String, Goods> vendingGoods : goods.entrySet()) {
                    Goods currentItem = vendingGoods.getValue();
                    System.out.println(currentItem.getSlot() + " || " + currentItem.getName() + " || " + "$" + currentItem.getPrice() + " || " + currentItem.getType() + " || (" + vendingGoods.getValue().getQuantity() + ")");
                }


                System.out.println();
                System.out.println("Please select item by Slot");
                String slot = UserInput.getSlot().toUpperCase();
                for (Map.Entry<String, Goods> vendingGoods : goods.entrySet()) {
                    if (vendingGoods.getKey().equals(slot)) {
                        if (vendingGoods.getValue().getQuantity() == 0) {
                            System.out.println("This is item is sold out!");
                        } else {
                            counter++;
                            vendingGoods.getValue().setQuantity();
                            BigDecimal transactionCost = new BigDecimal("0");
                            if (counter % 2 == 0) {
                                transactionCost = vendingGoods.getValue().getPrice().subtract(BigDecimal.valueOf(1));

                            } else {
                                transactionCost = vendingGoods.getValue().getPrice();

                            }
                            try (PrintWriter writer = new PrintWriter(new FileOutputStream(auditFile, true));) {

                                writer.println(formattedDate + "" + LocalTime.now() + "" + vendingGoods.getValue().getName() + "" + slot + "" + balance + "" + balance.subtract(transactionCost));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            balance = balance.subtract(transactionCost);

                            if (vendingGoods.getValue().getType().equals("Munchy")) {
                                System.out.println(vendingGoods.getValue().getName() + ": Munchy, Munchy, so Good!");
                            } else if (vendingGoods.getValue().getType().equals("Candy")) {
                                System.out.println(vendingGoods.getValue().getName() + ": Sugar, Sugar, so Sweet!");
                            } else if (vendingGoods.getValue().getType().equals("Drinks")) {
                                System.out.println(vendingGoods.getValue().getName() + ": Drinky, Drinky, Slurp Slurp!");
                            } else if (vendingGoods.getValue().getType().equals("Gum")) {
                                System.out.println(vendingGoods.getValue().getName() + ": Chewy, Chewy, Lots O' Bubbles!");
                            }
                            System.out.println("Price: $" + vendingGoods.getValue().getPrice());
                            System.out.println("current balance: " + balance);

                        }


                    }

                }


            } else if (purchaseChoice.equalsIgnoreCase("Finish Transaction")) {
                int nickels = 0;
                int dimes = 0;
                int quarters = 0;
                int dollars = 0;
                BigDecimal amountNickels = new BigDecimal("0.05");
                BigDecimal amountDimes = new BigDecimal(("0.10"));
                BigDecimal amountQuarters = new BigDecimal(("0.25"));
                BigDecimal amountDollars = new BigDecimal(("1.00"));

                while (balance.compareTo(amountDollars) >= 0) {
                    dollars++;
                    balance = balance.subtract(amountDollars);
                }
                while (balance.compareTo(amountQuarters) >= 0) {
                    quarters++;
                    balance = balance.subtract(amountQuarters);
                }
                while (balance.compareTo(amountDimes) >= 0) {
                    dimes++;
                    balance = balance.subtract(amountDimes);
                }
                while (balance.compareTo(amountNickels) >= 0) {
                    nickels++;
                    balance = balance.subtract(amountNickels);
                }
                try(PrintWriter writer = new PrintWriter(new FileOutputStream(auditFile, true));)
                {

                    writer.println(formattedDate + "" + LocalTime.now() + "Change Given" + balance + "0.00");
                } catch  (FileNotFoundException e) {
                    e.printStackTrace();
                }


                System.out.println("Your change is: " + "Dollars: " + dollars + ", " + "Quarters: " + quarters + ", " + "Dimes: " + dimes + ", " + "Nickels: " + nickels);

                stay = false;
            }
    }
        while (stay);
        }


    }
