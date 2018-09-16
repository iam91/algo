package tag.dp;

public class HouseRobberII {
    // https://leetcode.com/problems/house-robber-ii/description/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp0 = new int[n + 1]; // don't rob the first house
        int[] dp1 = new int[n + 1]; // don't rob the last house

        dp0[2] = nums[1];
        for(int i = 3; i <= n; i++) {
            dp0[i] = Math.max(dp0[i - 2] + nums[i - 1], dp0[i - 1]);
        }
        dp1[1] = nums[0];
        for(int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
        }
        return Math.max(dp0[n], dp1[n - 1]);
    }
}
