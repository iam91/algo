package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    // https://leetcode.com/problems/permutations/description/
    public List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(nums, 0, flag, res, path);
        return res;
    }

    private void dfs(int[] nums, int d, int[] flag, List<List<Integer>> res, List<Integer> path) {
        if(d == nums.length) {
            List<Integer> t = new LinkedList<>(path);
            res.add(t);
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(flag[i] == 0) {
                    flag[i] = 1;
                    path.add(nums[i]);
                    dfs(nums, d + 1, flag, res, path);
                    flag[i] = 0;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
