package tag.math.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
        // return brute(nums, target);
        // return twoPass(nums, target);
        return onePass(nums, target);
    }

    private int[] brute(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        return null;
    }

    private int[] twoPass(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(target - nums[i], i);
        }

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                int[] res = {i, map.get(nums[i])};
                return res;
            }
        }
        return null;
    }

    private int[] onePass(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.getOrDefault(nums[i], -1) > -1) {
                int[] res = {i, map.get(nums[i])};
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
