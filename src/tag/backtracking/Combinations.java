package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    // https://leetcode.com/problems/combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(1, 0, n, k, res, path);
        return res;
    }

    private void dfs(int c, int d, int n, int k, List<List<Integer>> res, List<Integer> path) {
        if(d == k) {
            List<Integer> t = new LinkedList<>(path);
            res.add(t);
        } else if(c <= n) {
            for(int i = c; i <= n; i++) {
                path.add(i);
                dfs(i + 1, d + 1, n, k, res, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> t = c.combine(4, 2);
    }
}
