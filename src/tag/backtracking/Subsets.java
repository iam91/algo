package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    // https://leetcode.com/problems/subsets/description/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int d, List<List<Integer>> res, List<Integer> path) {
        if(d == nums.length) {
            List<Integer> c = new LinkedList<>();
            c.addAll(path);
            res.add(c);
        } else {
            path.add(nums[d]);
            dfs(nums, d + 1, res, path);
            path.remove(path.size() - 1);
            dfs(nums, d + 1, res, path);
        }
    }
}
