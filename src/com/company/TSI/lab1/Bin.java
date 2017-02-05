package com.company.TSI.lab1;

import java.math.BigInteger;
import java.util.ArrayList;

public class Bin {
    public static final int BIN_LENGTH = 8;
    private String bin;

    public Bin(String bin) {
        this.bin = bin;
    }

    public String getBin() {
        return bin;
    }


    public static ArrayList<Hex> arrayBinToArrayHex(ArrayList<Bin> arrayBin) {
        ArrayList<Hex> arrayHex = new ArrayList<Hex>();

        for (Bin bin: arrayBin) {
            arrayHex.add(new Hex(binToHex(bin.getBin()).toUpperCase()));
        }

        return arrayHex;
    }

    private static String binToHex(String bin) {
        String hex = new BigInteger(bin, 2).toString(16);
        if (hex.length() < 2) {
            return "0" + hex;
        }
        return hex;
    }

    public static String checkBinToLegth(String bin) {
        if (bin.length() == Bin.BIN_LENGTH) {
            return bin;
        }
        for (int i = bin.length(); i < Bin.BIN_LENGTH; i++ ) {
            bin = "0" + bin;
        }


        return bin;
    }

    public static ArrayList<Bin> allBinElementsToBinList(ArrayList<String> allBinElements) {
        ArrayList<Bin> binArrayList = new ArrayList<Bin>();
        String binElement = "";
        int counter = 0;

        for (int i = 0; i< allBinElements.size(); i++ ) {
            binElement += allBinElements.get(i);
            counter++;
            if (counter == BIN_LENGTH) {
                binArrayList.add(new Bin(binElement));
                binElement = "";
                counter = 0;
            }
        }

        if (counter!=0) {
            binArrayList.add(new Bin(checkBinToLegth(binElement)));
        }
        return binArrayList;
    }

    @Override
    public String toString() {
        return bin;
    }
}
