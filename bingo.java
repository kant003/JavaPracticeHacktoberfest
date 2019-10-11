// Program that accepts 2 nos. in the range 1-40 from command line then compares these nos against a single
// dimension array of 5 int elements ranging 1-40. Diplay the message "Bingo" if the two input values are found in the
// array elements.otherwise "Not Found."

public class test1 {
    public static void main(String args[]){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int arr[] = new int[5];
        for(int i=0;i<5;i++){
            arr[i] = Integer.parseInt(args[i+2]);
        }
        int flag=0;
        for(int i=0;i<5;i++){
            if(a==arr[i]){
                flag++;
            }
            if (b==arr[i]){
                flag++;
            }
        }
        if(flag==2){
            System.out.println("Bingo!");
        }
        else {
            System.out.println("Not Found!");
        }
    }
}
