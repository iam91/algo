package tag.math.game;

public class CoinsLineII {
    // https://www.lintcode.com/problem/coins-in-a-line-ii/description
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0) return false;

        int n = values.length;
        if(n < 3) return true;

        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) sum[i] = sum[i + 1] + values[i];
        dp[n - 1] = values[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = sum[i] - Math.min(dp[i + 1], dp[i + 2]);
        }

        return dp[0] * 2 > sum[0];
    }
}
