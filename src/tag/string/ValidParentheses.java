package tag.string;

import java.util.Stack;

public class ValidParentheses {
    // https://leetcode.com/problems/valid-parentheses/description/
    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else if(!stack.isEmpty()) {
                char top = stack.peek();
                if(ch == ')' && top == '(') stack.pop();
                else if(ch == ']' && top == '[') stack.pop();
                else if(ch == '}' && top == '{') stack.pop();
                else return false;
            } else return false;
        }

        return stack.isEmpty();
    }
}
