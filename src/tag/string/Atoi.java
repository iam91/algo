package tag.string;

public class Atoi {
    // https://leetcode.com/problems/string-to-integer-atoi/description/
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int n = str.length();
        int res = 0;
        int i = 0;

        while(i < n && str.charAt(i) == ' ') i++;
        int sign = i < n && str.charAt(i) == '-' ? -1 : 1;
        if(i < n && (str.charAt(i) == '-' || str.charAt(i) == '+')) i++;

        char ch;
        while(i < n && Character.isDigit(ch = str.charAt(i))) {
            int curr = ch - '0';
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && curr > 7) return Integer.MAX_VALUE;
            if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && curr > 8) return Integer.MIN_VALUE;
            i++;
            res = res * 10 + curr * sign;
        }
        return res;
    }

    public static void main(String[] args) {
        Atoi c = new Atoi();
        System.out.println(c.myAtoi("+"));
    }
}
