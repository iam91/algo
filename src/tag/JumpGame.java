package tag;

public class JumpGame {
    // https://leetcode.com/problems/jump-game/description/
    public boolean canJump(int[] nums) {
        // return bruteForce(nums);
        return greedy(nums);
    }

    private boolean bruteForce(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;
        int[] d = new int[n];

        d[0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] >= i - j) {
                    d[i] += d[j];
                }
            }
        }

        return d[n - 1] > 0;
    }

    private boolean greedy(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;
        int remain = 1;
        for(int i = 0; i < n; i++) {
            if(--remain < 0) return false;
            else remain = Math.max(remain, nums[i]);
        }
        return remain >= 0;
    }
}
