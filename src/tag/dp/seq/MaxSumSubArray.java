package tag.dp.seq;

public class MaxSumSubArray {
    // https://leetcode.com/problems/maximum-subarray/description/
    public int maxSubArray(int[] nums) {
        // return dp(nums);
        // return dp1(nums);
        return dc(nums, 0, nums.length);
    }

    private int dc(int[] nums, int left, int right) {
        if(nums == null || nums.length == 0 || left >= right) return 0;
        if(left == right - 1) return nums[left];

        int mid = left + (right - left) / 2;
        int leftMax = dc(nums, left, mid);
        int rightMax = dc(nums, mid, right);

        int leftSum = 0, maxL = Integer.MIN_VALUE;
        for(int i = mid - 1; i >= left; i--) {
            leftSum += nums[i];
            maxL = Math.max(maxL, leftSum);
        }

        int rightSum = 0, maxR = Integer.MIN_VALUE;
        for(int i = mid; i < right; i++) {
            rightSum += nums[i];
            maxR = Math.max(maxR, rightSum);
        }

        return Math.max(maxL + maxR, Math.max(leftMax, rightMax));
    }

    private int dp(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private int dp1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int pre = nums[0];
        int max = pre;
        for(int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }

        return max;
    }
}
