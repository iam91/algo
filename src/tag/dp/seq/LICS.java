package tag.dp.seq;

public class LICS {
    // https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
