package tag.dp;

public class PaintHouseII {
    // https://www.lintcode.com/problem/paint-house-ii/description
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        int min0 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        int min0Idx = -1;
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if(dp[0][i] < min0) {
                min1 = min0;
                min0 = dp[0][i];
                min0Idx = i;
            } else if(dp[0][i] < min1) {
                min1 = dp[0][i];
            }
        }

        for(int i = 1; i < n; i++) {
            int min0_, min1_, min0Idx_, min1Idx_;
            min0_ = min1_ = Integer.MAX_VALUE;
            min0Idx_ = -1;
            for(int j = 0; j < k; j++) {
                dp[i][j] = (j == min0Idx ? min1 : min0) + costs[i][j];
                if(dp[i][j] < min0_) {
                    min1_ = min0_;
                    min0_ = dp[i][j];
                    min0Idx_ = j;
                } else if(dp[i][j] < min1_){
                    min1_ = dp[i][j];
                }
            }
            min0 = min0_;
            min1 = min1_;
            min0Idx = min0Idx_;
        }

        return min0;
    }
}
