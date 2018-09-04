package tag.math.random;

import java.util.Random;

public class RandomPickIndex {
    // https://leetcode.com/problems/random-pick-index/description/
    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int n = this.nums.length;
        int c = 0;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                idx = this.rand.nextInt(++c) == 0 ? i : idx;
            }
        }
        return idx;
    }
}
