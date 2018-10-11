public class DampfSchiffFahrt {

    public static void main(String[] args) {

        //A german variant of FizzBuzz with 3 different divisors that prints the german word for each number that is
        //not "Fizz", "Buzz" oder "FizzBuzz"
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i % 3 == 0 && i % 5 == 0) {
                System.out.println("DampfSchiffFahrt");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("SchiffFahrt");
            } else if (i % 2 == 0 && i % 3 == 0) {
                System.out.println("DampfSchiff");
            } else {
                System.out.println(zahlZuWort(i));
            }
        }
    }

    /**Macht aus den eingegebenen Integer-Werten von 1-100 das deutsche Zahlenwort
     *
     * @param zahl  Integer, für den das Zahlenwort ausgegeben werden soll
     * @return  Zahlenwort auf deutsch
     */
    static String zahlZuWort (int zahl) {
        String numberString = "";
        String zahlString = String.valueOf(zahl);

        String[] einer = {"ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};
        String[] zehner = {"zehn", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig", "siebzig", "achtzig", "neunzig"};

        if (zahlString.length() == 1) {
            if (zahlString.charAt(0) == '1') {
                    numberString = "eins";
            } else {
                numberString = einer[Character.getNumericValue(zahlString.charAt(0))-1];
            }
        } else if (zahlString.length() == 2) {
            if (zahlString.charAt(0) == '1') {
                if (zahlString.charAt(1) == '0') {
                    numberString = "zehn";
                } else {
                    numberString = elfBisNeunZehn(numberString, zahlString);
                }
            } else {
                if (zahlString.charAt(1) == '0') {
                    numberString = zehner[Character.getNumericValue(zahlString.charAt(0))-1];
                } else {
                    numberString = einer[Character.getNumericValue(zahlString.charAt(1))-1].concat("und").concat(zehner[Character.getNumericValue(zahlString.charAt(0))-1]);
                }
            }
        } else {
            numberString = "einhundert";
        }

        return numberString;
    }

    /** Switch für die Zahlen von eins bis neunzehn. Durch die deutsche Sprache einfacherere Umsetzung als
     * Aufteilung auf mit den String-Arrays mögliche und unmögliche Zahlenwörter. Einige Werte wären für die Verwendung
     * in der DampfSchiffFahrt-Aufgabe gar nicht nötig.
     *
     * @param numberString  Zahlenwort als String
     * @param zahlString    Zahl als String
     * @return  Zahlenwort
     */
    private static String elfBisNeunZehn(String numberString, String zahlString) {
        switch (zahlString.charAt(1)) {
            case '1':
                numberString = "elf";
                break;
            case '2':
                numberString = "zwölf";
                break;
            case '3':
                numberString = "dreizehn";
                break;
            case '4':
                numberString = "vierzehn";
                break;
            case '5':
                numberString = "fünfzehn";
                break;
            case '6':
                numberString = "sechzehn";
                break;
            case '7':
                numberString = "siebzehn";
                break;
            case '8':
                numberString = "achtzehn";
                break;
            case '9':
                numberString = "neunzehn";
                break;
        }
        return numberString;
    }
}
