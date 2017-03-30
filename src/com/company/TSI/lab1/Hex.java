package com.company.TSI.lab1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Hex {
    private String hex;

    public Hex(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

    private static String hexToBin(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }

    public static ArrayList<Bin> arrayHexToArrayBin(ArrayList<Hex> arrayHex) {
        ArrayList<Bin> arrayBin = new ArrayList<Bin>();
        Bin currentBin;

        for (Hex hex: arrayHex) {
            currentBin = new Bin(Bin.checkBinToLegth(hexToBin(hex.getHex())));
            arrayBin.add(currentBin);
        }

        return arrayBin;
    }

    public static ArrayList<Hex> stringHexToArrayList(String hexNumbers) {
        ArrayList<Hex> hexList = new ArrayList<Hex>();
        ArrayList<String> stringHexList = new ArrayList<String>();

        stringHexList.addAll(Arrays.asList(hexNumbers.trim().split(" ")));

        for (String hex: stringHexList) {
            hexList.add(new Hex(hex));
        }

        return hexList;
    }

    @Override
    public String toString() {
        return hex;
    }
}
