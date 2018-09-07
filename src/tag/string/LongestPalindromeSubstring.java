package tag.string;

public class LongestPalindromeSubstring {
    // https://leetcode.com/problems/longest-palindromic-substring/description/
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();
        String res = "";
        for(int i = 0; i < n; i++) {
            // i as middle
            String t1, t2 = "";
            t1 = expand(s, i, i);
            if(i < n - 1) {
                t2 = expand(s, i, i + 1);
            }
            if(t1.length() > res.length()) res = t1;
            if(t2.length() > res.length()) res = t2;
        }

        return res;
    }

    private String expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(right - left >= 2) return s.substring(left + 1, right);
        else if(right - left == 1) return s.substring(left, right);
        else return s.substring(left, right + 1);
    }
}
