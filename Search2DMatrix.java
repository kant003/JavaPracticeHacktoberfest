/**
 * Search2DMatrix.java
 * 
 * This program provides a solution to efficiently search for a target value
 * in a 2D matrix where each row is sorted and the first element of each row
 * is greater than the last element of the previous row.
 * 
 * The search uses a binary search approach by treating the 2D matrix as a 
 * flattened 1D array.
 */

public class Search2DMatrix {

    public static void main(String[] args) {

        // Test case 1
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix1, 3));   // true
        System.out.println(searchMatrix(matrix1, 13));  // false

        // Test case 2
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println(searchMatrix(matrix2, 6));   // true
        System.out.println(searchMatrix(matrix2, 0));   // false

        // Test case 3
        int[][] matrix3 = {
            {1}
        };
        System.out.println(searchMatrix(matrix3, 1));   // true
        System.out.println(searchMatrix(matrix3, 2));   // false
    }

    /**
     * Searches for a target value in a 2D matrix.
     * 
     * @param matrix The 2D matrix of integers.
     * @param target The integer value to search for.
     * @return True if the target is found; false otherwise.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int low = 0;
        int high = numRows * numCols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / numCols;
            int col = mid % numCols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
