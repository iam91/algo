class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int max = 0;
        while(idx < n) {
            int len = 0, i;
            // probe
            for(i = idx; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == '(') {
                    stack.push(i);
                    if(stack.size() * 2 + len > n - idx) {
                        // too many left parentheses
                        if(stack.size() == 1) {

                        }
                    }
                }
                if(ch == ')') {
                    if(!stack.isEmpty()) {
                        stack.pop();
                        len += 2;
                    } else {
                        // too many right parentheses
                        max = Math.max(max, len);
                        idx = i + 1;
                        break;
                    }
                }
            }
        }
        return max;
    }
}