package tag.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    // https://leetcode.com/problems/combination-sum-ii/description/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, res, path);
        return res;
    }

    private void dfs(int[] can, int idx, int sum, int target, List<List<Integer>> res, List<Integer> path) {
        if(sum == target) {
            List<Integer> t = new LinkedList<>(path);
            res.add(t);
        } else {
            int id = idx;
            while(id < can.length) {

                int c = 0;
                for(int i = id; i < can.length; i++) {
                    if(can[i] == can[id]) c++;
                }
                int addCnt = 0;
                for(int i = 1; i <= c; i++) {
                    if(can[id] <= target - sum) {
                        addCnt++;
                        path.add(can[id]);
                        sum += can[id];
                        dfs(can, id + c, sum, target, res, path);
                    }
                }
                for(int i = 1; i <= addCnt; i++) {
                    path.remove(path.size() - 1);
                    sum -= can[id];
                }

                id += c;
            }
        }
    }
}
