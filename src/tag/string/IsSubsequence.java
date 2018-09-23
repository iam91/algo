package tag.string;

public class IsSubsequence {
    // https://leetcode.com/problems/is-subsequence/description/
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0) return true;

        int sIdx = 0;
        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(sIdx) == t.charAt(i)) sIdx++;
            if(sIdx >= s.length()) return true;
        }
        return false;
    }
}
