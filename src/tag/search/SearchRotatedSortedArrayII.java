package tag.search;

public class SearchRotatedSortedArrayII {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[left] < nums[right - 1]) {
                if(nums[mid] > target) right = mid;
                if(nums[mid] < target) left = mid + 1;
            } else if(nums[left] > nums[right - 1]){
                if(nums[mid] >= nums[left]) {
                    if(nums[mid] > target && target >= nums[left]) right = mid;
                    else left = mid + 1;
                } else {
                    if(nums[mid] < target && target <= nums[right - 1]) left = mid + 1;
                    else right = mid;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
