package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    private static String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;

        StringBuilder com = new StringBuilder();
        backtrack(res, digits, 0, com);
        return res;
    }

    private void backtrack(List<String> res, String digits, int pos, StringBuilder com) {
        if(pos == digits.length()) {
            res.add(com.toString());
        } else {
            int val = digits.charAt(pos) - '0';
            String chars = this.map[val - 1];
            for(int i = 0; i < chars.length(); i++) {
                char ch = chars.charAt(i);
                com.append(ch);
                backtrack(res, digits, pos + 1, com);
                com.deleteCharAt(com.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber c = new LetterCombinationOfPhoneNumber();
        List<String> res = c.letterCombinations("23");
    }
}
