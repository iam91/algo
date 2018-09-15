package tag.dp;

public class PaintHouse {
    // https://www.lintcode.com/problem/paint-house/description
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length;
        int[][] dp = new int[n][3];

        for(int i = 0; i < 3; i++) dp[0][i] = costs[0][i];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {
                    if(k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) min = Math.min(min, dp[n - 1][i]);

        return min;
    }
}
