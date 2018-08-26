package tag.dp;

public class LICS {
    // https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int[] dp = new int[n];

        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}
