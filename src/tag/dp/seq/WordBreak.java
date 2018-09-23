package tag.dp.seq;

import java.util.List;

public class WordBreak {
    // https://leetcode.com/problems/word-break/description/
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        for(String w: wordDict) {
            int k = w.length();
            if(k <= n) dp[k] = dp[k] || (s.indexOf(w) == 0);
        }

        for(int i = 1; i <= n; i++) {
            for(String w: wordDict) {
                int k = w.length();
                boolean flag = false;
                if(i - k > 0) {
                    flag = dp[i - k] && s.substring(i - k, i).equals(w);
                }
                dp[i] = dp[i] || flag;
            }
        }

        return dp[n];
    }
}
