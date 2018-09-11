package tag;

public class JumpGame {
    // https://leetcode.com/problems/jump-game/description/
    public boolean canJump(int[] nums) {
        return naive(nums);
    }

    private boolean naive(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] >= i - j) {
                    dp[i] += dp[j];
                }
            }
        }

        return dp[n - 1] > 0;
    }

    private boolean linear(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;

    }
}
