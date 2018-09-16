package tag.array;

public class BestTimeToBuyAndSellStockII {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int n = prices.length;
        int acc = 0;

        int start = prices[0];
        int idx = 1;
        while(idx < n) {
            while(idx < n && prices[idx] >= prices[idx - 1]) {
                acc += (prices[idx] - prices[idx - 1]);
                idx++;
            }
            idx++;
        }
        return acc;
    }
}
