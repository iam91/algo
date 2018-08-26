package tag.search;

public class InsertPosition {
    // https://leetcode.com/problems/search-insert-position/description/
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
