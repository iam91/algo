package tag.math.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    // https://leetcode.com/problems/3sum/description/
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int complete = -nums[i];
            int j = i + 1, k = n - 1;
            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum == complete) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                } else if(sum > complete) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
