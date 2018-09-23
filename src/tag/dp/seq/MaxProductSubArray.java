package tag.dp.seq;

public class MaxProductSubArray {
    // https://leetcode.com/problems/maximum-product-subarray/description/
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int max = dpMax[0];
        for(int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            max = Math.max(max, dpMax[i]);
        }

        return max;
    }
}
