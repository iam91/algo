package tag.dp;

public class HouseRobber {
    // https://leetcode.com/problems/house-robber/description/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        HouseRobber c = new HouseRobber();
        int[] nums = {1,2,3,1};
        c.rob(nums);
    }
}
