package tag;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        if(S == null || T == null) return 0;
        if(S.length() < T.length()) return 0;

        char[] dict = new char[26];
        boolean[] flag = new boolean[26];

        int n = S.length();
        int m = T.length();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(i + m <= n) {
                String sub = S.substring(i, i + m);
                int j;
                for(j = 0; j < m; j++) {
                    int idx = sub.charAt(j) - 'a';
                    if(dict[idx] == '\0') {
                        if(flag[T.charAt(j) - 'a']) break;
                        dict[idx] = T.charAt(j);
                        flag[T.charAt(j) - 'a'] = true;
                    } else {
                        if(dict[idx] != T.charAt(j)) break;
                    }

                }
                if(j == m) cnt++;
                for(int k = 0; k < 26; k++) {
                    dict[k] = '\0';
                    flag[k] = false;
                }
            }
        }

        return cnt;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}
