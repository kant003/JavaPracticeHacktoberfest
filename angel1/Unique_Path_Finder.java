class Unique_Path_Finder {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m+1][n+1];
            for(int[] i: dp) Arrays.fill(i, -1);
            return totalPath(0, 0, m, n, dp);
        }

        public int totalPath(int i, int j, int m, int n, int[][] dp) {
            if (i == m - 1 && j == n - 1) return 1;
            else if (i >= m || j >= n) return 0;

            if (dp[i][j] != -1) return dp[i][j];

            int count = totalPath(i + 1, j, m, n, dp) + totalPath(i, j + 1, m, n, dp);

            return dp[i][j] = count;
        }
}