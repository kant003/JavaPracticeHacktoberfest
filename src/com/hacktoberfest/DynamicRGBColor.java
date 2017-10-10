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

public class DynamicRGBColor {

    public DynamicRGBColor() {
        Color dynamicColor = generateDynamicColor();
        System.out.println(dynamicColor.toString());
    }

    /**
     * Generate dynamic color
     * @return Color
     */
    private Color generateDynamicColor() {

        int R = randomWithRange(0, 255);
        int G = randomWithRange(0, 255);

        int B = randomWithRange(0, 255);
        return new Color(R,G,B);

    }

    /**
     * RGB Max Value is 255 Min Value is 0, So here its getting min max value to generate RGB value.
     * @param min
     * @param max
     * @return int
     */
    private int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static void main(String[] args) {
        new DynamicRGBColor();
    }

}
