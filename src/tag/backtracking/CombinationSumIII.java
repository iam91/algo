package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    // https://leetcode.com/problems/combination-sum-iii/description/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(1, 0, 0, k, n, res, path);
        return res;
    }

    private void dfs(int c, int num, int sum, int k, int n, List<List<Integer>> res, List<Integer> path) {
        if(num == k && sum == n) {
            List<Integer> t = new LinkedList<>(path);
            res.add(t);
        } else if(num < k) {
            for(int i = c; i <= 9; i++) {
                if(i <= n - sum) {
                    path.add(i);
                    dfs(i + 1, num + 1, sum + i, k, n, res, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
