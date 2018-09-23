package tag.dp.doubleseq;

public class LCCS {
    // Longest Common Continuous SubSequence
    // https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;

        int n = A.length, m = B.length;
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = A[0] == B[j] ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
