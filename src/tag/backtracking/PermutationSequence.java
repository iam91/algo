package tag.backtracking;

public class PermutationSequence {
    // https://leetcode.com/problems/permutation-sequence/description/
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) nums[i - 1] = i;

        while((--k) > 0) { nextPermutation(nums); }

        String res = "";
        for(int i = 0; i < n; i++) res += Integer.toString(nums[i]);
        return res;
    }

    private void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1, j;
        while(i > 0) {
            if(nums[i - 1] >= nums[i]) {
                i--;
            } else {
                j = n - 1;
                while(j >= i) {
                    if(nums[j] <= nums[i - 1]) {
                        j--;
                    } else {
                        swap(nums, i - 1, j);
                        j = n - 1;
                        while(i < j) swap(nums, i++, j--);
                        return;
                    }
                }
            }
        }

        if(i == 0) {
            j = n - 1;
            while(i < j) swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
