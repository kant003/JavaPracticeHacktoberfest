public class nQueen{
    public static void main(String args[]){
        int n=4;
        char board[][] = new char[n][n];
        int row=0;
        // initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        nQueen(board, row);
        System.out.println("Total number of boards for n queens: " +  count);
    }

    static int count = 0;

    public static void printBoard(char board[][]){

        System.out.println("----------chess board--------------");
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueen(char board[][], int row){

        // base
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }

        // column loop
        for(int j = 0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueen(board, row+1);    // function call
                board[row][j] = '.';    // backtracking step (removing the queen bec each row can have only one queen)
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
            // 3 conditions to check for attacks

            // 1. ek col me ek hi queen (Vertical up Check)
            for(int i=row-1; i>=0; i--){
                if(board[i][col] == 'Q'){
                    return false;
                }
            }

            // 2. no queens in diagonal left up (Diagonal up Check)
            for(int i=row-1, j = col-1; i>=0 && j>=0; i--, j--){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }

            // 3. no queens in diagonal right up (Diagonal up Check)
            for(int i=row-1, j = col+1; i>=0 && j<board.length; i--, j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
            return true;
    }
}