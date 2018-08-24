package tag.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    // https://leetcode.com/problems/subsets-ii
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int d, List<List<Integer>> res, List<Integer> path) {
        if(nums.length == d) {
            List<Integer> c = new LinkedList<>(path);
            res.add(c);
        } else {
            int c = 0;
            for(int i = d; i < nums.length; i++) {
                if(nums[i] == nums[d]) c++;
            }

            dfs(nums, d + c, res, path);
            for(int i = 1; i <= c; i++) {
                path.add(nums[d]);
                dfs(nums, d + c, res, path);
            }
            for(int i = 1; i <= c; i++) {
                path.remove(path.size() - 1);
            }
        }
    }
}
