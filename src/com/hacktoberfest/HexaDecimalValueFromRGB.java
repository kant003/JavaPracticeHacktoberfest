package com.hacktoberfest;/*
// *************************************************************************************************
// PROJECT : JavaPracticeHacktoberfest
// *************************************************************************************************
// Author : chikaslocalhost
// Date : 10/27/16
// Since : version 1.0
// ****************************************************************************************************
*/

import java.awt.*;

public class HexaDecimalValueFromRGB {

    public HexaDecimalValueFromRGB() {

        Color color = Color.CYAN;
        String hexValue = getHexValueFromColor(color);
        System.out.println(hexValue);
    }

    /**
     * This method will generate the HEXA value from RGB value
     * @param color
     * @return
     */
    private String getHexValueFromColor(Color color) {

        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();

        String hex = String.format("#%02x%02x%02x", R, G, B);
        return hex;
    }

    public static void main(String[] args) {
        new HexaDecimalValueFromRGB();
    }
}
