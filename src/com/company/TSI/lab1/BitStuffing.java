package com.company.TSI.lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class BitStuffing {
    private static final int MAX_COUNT_OF_1 = 5;


    public static ArrayList<String> doBitStuffing(String numberInHex) {
        ArrayList<Hex> hexNumbs = Hex.stringHexToArrayList(numberInHex);
        ArrayList<Bin> binNumbs = Hex.arrayHexToArrayBin(hexNumbs);

        ArrayList<String> allBinElements = bitStuffingProces(doAllBinElementsList(binNumbs));

        binNumbs = Bin.allBinElementsToBinList(allBinElements);

        hexNumbs = Bin.arrayBinToArrayHex(binNumbs);
        System.out.println(Arrays.asList(hexNumbs));

        return allBinElements;
    }

    private static ArrayList<String> bitStuffingProces(ArrayList<String> allElements) {
        int counter = 0;
        String curentElement;

        for (int i = 0; i < allElements.size(); i++) {
            curentElement = allElements.get(i);

            if (curentElement.equals("1")) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == MAX_COUNT_OF_1) {
                allElements.add(i+1, "0");
                counter = 0;
            }
        }
        return allElements;
    }

    private static ArrayList<String> doAllBinElementsList(ArrayList<Bin> binNumbs) {
        ArrayList<String> allElements = new ArrayList<String>();
        String stringBin;
        for (Bin bin: binNumbs) {
            stringBin = bin.getBin();
            allElements.addAll(Arrays.asList(stringBin.trim().split("")));
        }

        return allElements;
    }

}
