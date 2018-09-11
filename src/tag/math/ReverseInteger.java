package tag.math;

public class ReverseInteger {
    // https://leetcode.com/problems/reverse-integer/description/
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int r = x % 10;
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && r > 7) return 0;
            if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && r < -8) return 0;
            res = res * 10 + r;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger c = new ReverseInteger();
        System.out.println(c.reverse(-123));
        System.out.println(Integer.MAX_VALUE % 10);
        System.out.println(Integer.MIN_VALUE % 10);
    }
}
