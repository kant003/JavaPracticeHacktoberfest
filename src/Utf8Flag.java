// Example for generating UTF-8 Country flags
// Read more: https://en.wikipedia.org/wiki/Regional_Indicator_Symbol

import java.util.Locale;

public class Utf8Flag {
    public static void main(String[] args) {
        int a = '\uDDE6'; // flag character represent A

        // print all available country with flag
        for (Locale l : Locale.getAvailableLocales()) {
            // UTF-8 flags generated from the two letters country code (US, UK, HU...)
            String s = l.getCountry();
            if (s.length() == 2) {
                // every flag is 4 UTF-8 character: '\uD83C' + modified country code[0] + '\uD83C" + modified country code[1]
                String flag =  " \uD83C" + (char)(s.toCharArray()[0] - 'A' + a) + '\uD83C' + (char)(s.toCharArray()[1] - 'A' + a);
                // print country + flag
                System.out.println(l.getDisplayCountry() + ": " + flag);
            }
        }

    }
}
