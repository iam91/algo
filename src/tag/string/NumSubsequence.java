package tag.string;

import java.util.HashMap;
import java.util.Map;

public class NumSubsequence {
    // https://leetcode.com/problems/number-of-matching-subsequences/description/
    public int numMatchingSubseq(String S, String[] words) {
        int cnt = 0;

        Map<String, Boolean> map = new HashMap<>();
        for(String w: words) {
            if(!map.containsKey(w)) map.put(w, isSubsequence(w, S));
            cnt += map.get(w) ? 1 : 0;
        }

        return cnt;
    }

    private boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0) return true;

        int sIdx = 0;
        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(sIdx) == t.charAt(i)) sIdx++;
            if(sIdx >= s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumSubsequence c = new NumSubsequence();

        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        c.numMatchingSubseq(S, words);
    }
}
