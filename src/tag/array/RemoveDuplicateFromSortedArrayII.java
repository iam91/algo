package tag.array;

public class RemoveDuplicateFromSortedArrayII {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int idx = 1, curr = nums[0], cnt = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] != curr) {
                nums[idx++] = nums[i];
                curr = nums[i];
                cnt = 1;
            } else if(cnt == 1) {
                nums[idx++] = curr;
                cnt = 0;
            }
        }

        return idx;
    }
}
