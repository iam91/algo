package tag.string;

public class LongestNonRepeatingSubstring {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        if(s == null|| s.length() == 0) return 0;
        int n = s.length();

        int[] len = new int[n];
        int[] dict = new int[128];

        for(int i = 0; i < 128; i++) dict[i] = -1;
        len[0] = 1;
        dict[s.charAt(0) - '\0'] = 0;

        int max = 1;
        for(int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if(len[i - 1] >= i - dict[ch - '\0']) {
                len[i] = i - dict[ch - '\0'];
            } else {
                len[i] = len[i - 1] + 1;
            }
            dict[ch - '\0'] = i;
            max = Math.max(max, len[i]);
        }

        return max;
    }
}
