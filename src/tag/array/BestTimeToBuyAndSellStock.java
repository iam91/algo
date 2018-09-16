package tag.array;

public class BestTimeToBuyAndSellStock {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        // return bruteForce(prices);
        return doublePointer(prices);
    }

    private int bruteForce(int[] prices) {
        int n = prices.length;

        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    private int doublePointer(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int max = 0;
        for(int i = 1; i < n; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return max;
    }
}
