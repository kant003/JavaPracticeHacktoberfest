/*
 * Algorithm: Longest Common Subsequence (LCS)
 * Language: Java
 * Description: Computes the length of the longest subsequence common to two strings.
 *              A subsequence is a sequence that appears in the same relative order,
 *              but not necessarily contiguous.
 * Time Complexity: O(n*m) where n = length of first string, m = length of second string
 * Space Complexity: O(n*m)
 */

public class LCS {

    /**
     * Function to compute the length of LCS between two strings.
     * Uses bottom-up Dynamic Programming approach.
     *
     * @param s1 First input string
     * @param s2 Second input string
     * @return Length of the longest common subsequence
     */
    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // Length of LCS
    }

    /**
     * Function to reconstruct the LCS string from the DP table.
     *
     * @param s1 First input string
     * @param s2 Second input string
     * @param dp DP table filled by longestCommonSubsequence
     * @return LCS string
     */
    public static String reconstructLCS(String s1, String s2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();
        int i = s1.length(), j = s2.length();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    /**
     * Test function for LCS implementation
     */
    public static void testLCS() {
        String[][] testCases = {
                {"AGGTAB", "GXTXAYB"},   // LCS: GTAB
                {"ABCDEF", "AEBDF"},     // LCS: ABDF
                {"HELLO", "WORLD"},      // LCS: LO
                {"", "ABC"},             // LCS: ""
                {"ABC", ""}              // LCS: ""
        };

        for (int t = 0; t < testCases.length; t++) {
            String s1 = testCases[t][0];
            String s2 = testCases[t][1];

            int n = s1.length();
            int m = s2.length();

            // Compute DP table
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            int lcsLength = dp[n][m];
            String lcsStr = reconstructLCS(s1, s2, dp);

            System.out.println("Test Case " + (t + 1) + ":");
            System.out.println("String 1: " + s1);
            System.out.println("String 2: " + s2);
            System.out.println("LCS Length: " + lcsLength);
            System.out.println("LCS: " + lcsStr);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing Longest Common Subsequence (LCS) Implementation\n");
        testLCS();
    }
}
