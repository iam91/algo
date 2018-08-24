package tag.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // https://leetcode.com/problems/combination-sum/description/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, res, path);
        return res;
    }

    private void dfs(int[] can, int idx, int sum, int target, List<List<Integer>> res, List<Integer> path) {
        if(sum == target) {
            List<Integer> t = new LinkedList(path);
            res.add(t);
        } else {
            for(int i = idx; i < can.length; i++) {
                if(can[i] <= target - sum) {
                    path.add(can[i]);
                    dfs(can, i, sum + can[i], target, res, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
