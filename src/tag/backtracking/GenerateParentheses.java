package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    // https://leetcode.com/problems/generate-parentheses/description/
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if(n == 0) return res;

        StringBuilder com = new StringBuilder();
        backtrack(res, com, n * 2, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder com, int len, int leftCnt, int availableCnt) {
        if(com.length() == len) {
            res.add(com.toString());
        } else {
            if(leftCnt < len / 2) {
                com.append('(');
                backtrack(res, com, len, leftCnt + 1, availableCnt + 1);
                com.deleteCharAt(com.length() - 1);
            }
            if(availableCnt > 0) {
                com.append(')');
                backtrack(res, com, len, leftCnt, availableCnt - 1);
                com.deleteCharAt(com.length() - 1);
            }
        }
    }
}
