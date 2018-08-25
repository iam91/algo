package tag.math.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    // https://leetcode.com/problems/4sum/description/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int l, int k) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();

        if(k == 2) {
            int i = l, j = n - 1;
            while(i < j) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    while(i < j && nums[i] == nums[i + 1]) i++;
                    i++;
                    while(i < j && nums[j] == nums[j - 1]) j--;
                    j--;
                } else if(sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            for(int i = l; i < n - k + 1; i++) {
                if(i > l && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k - 1);
                for(List<Integer> t: temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum c = new FourSum();
        int[] nums = {1,0,-1,0,-2,2};
        c.fourSum(nums, 0);
    }
}
