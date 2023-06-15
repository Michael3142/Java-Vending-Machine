package com.techelevator.controller;

import com.techelevator.models.*;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class ReadDataFile {

    public Map<String,Goods> loadFile(String inputFile) {
        File dataFile = new File(inputFile);

        Map<String,Goods> returnGoods = new HashMap<>();

        try (Scanner dataFileScanner = new Scanner(dataFile)) {
            while (dataFileScanner.hasNextLine()) {
                while (dataFileScanner.hasNextLine()) {
                    Goods currentGoods = null;
                    String currentLine = dataFileScanner.nextLine();
                    String[] currentLineSplit = currentLine.split(",");
                    if (currentLineSplit.length == 4) {
                        String slot = currentLineSplit[0];
                        String name = currentLineSplit[1];
                        String price = currentLineSplit[2];
                        BigDecimal priceAsBigDecimal = new BigDecimal(price);
                        String type = currentLineSplit[3];


                        if (type.equals("Munchy")) {
                            //load munchies
                            currentGoods = new Munchy(slot, name, priceAsBigDecimal);
                        } else if (type.equals("Candy")) {
                            //load candy with constructor
                            currentGoods = new Candy(slot, name, priceAsBigDecimal);
                        } else if (type.equals("Drink")) {
                            // load a drink with constructor
                            currentGoods = new Drinks(slot, name, priceAsBigDecimal);
                        } else if (type.equals("Gum")) {
                            currentGoods = new Gum(slot, name, priceAsBigDecimal);
                        } else {
                            //ERROR: not found
                        }
                        returnGoods.put(slot,currentGoods);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnGoods;
    }
}