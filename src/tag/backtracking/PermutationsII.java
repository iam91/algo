package tag.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    // https://leetcode.com/problems/permutations-ii/description/
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] flag = new int[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, flag, res, path);
        return res;
    }

    private void dfs(int[] nums, int d, int[] flag, List<List<Integer>> res, List<Integer> path) {
        if(d == nums.length) {
            List<Integer> t = new LinkedList(path);
            res.add(t);
        } else {
            int i = 0;
            while(i < nums.length) {
                int c = 1;
                if(flag[i] == 0) {
                    for(int j = i + 1; j < nums.length; j++) {
                        if(nums[j] == nums[i]) c++;
                    }
                    flag[i] = 1;
                    path.add(nums[i]);
                    dfs(nums, d + 1, flag, res, path);
                    flag[i] = 0;
                    path.remove(path.size() - 1);
                }

                i += c;
            }
        }
    }
}
