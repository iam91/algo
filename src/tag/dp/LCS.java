package tag.dp;

public class LCS {
    // https://www.lintcode.com/problem/longest-common-subsequence/description
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0 || B == null || B.length() == 0) return 0;
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : 0;
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = A.charAt(0) == B.charAt(j) ? 1 : 0;
        }

        int max = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = A.charAt(i) == B.charAt(j) ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
