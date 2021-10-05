package diamond;

public class DiamondPt2 {

    public static void main(String[] args) {
        String ary1[] = {"11", "b", "b", "c"};
        int lines = (Integer.parseInt(ary1[0]));
        
        for (int k = 0; k < ary1.length;k++){
            k++;
        }

        for (int i = 1; i < lines; i += 2) {
            for (int j = 0; j < (lines - i) / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                if (j != 0 && j != i - 1) { 
                    System.out.print(" ");
                } else {
                    System.out.print(ary1[1]);
                }
            }

            System.out.print("\n");
        }

        for (int i = lines; i > 0; i -= 2) {
            for (int j = 0; j < (lines - i) / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                if (j != 0 && j != i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print(ary1[1]);
                }
            }

            System.out.print("\n");
        }
    }
}
