package tag.dp.sequence;

public class LICS {
    // https://leetcode.com/problems/longest-increasing-subsequence/description/
    public int lengthOfLIS(int[] nums) {
         return dp(nums);
    }

    public int dp(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
