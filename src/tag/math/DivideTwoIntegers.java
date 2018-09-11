package tag.math;

public class DivideTwoIntegers {
    // https://leetcode.com/problems/divide-two-integers/description/
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;

        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        long res = 0;

        if(m < n) return 0;
        while(m >= n) {
            long t = n, p = 1;
            while(m > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }

        boolean isNeg = (dividend > 0) ^ (divisor > 0);
        if(!isNeg && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return isNeg ? -(int)res : (int)res;
    }
}
