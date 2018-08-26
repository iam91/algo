package tag.math;

public class Pow {
    // https://leetcode.com/problems/powx-n/description/
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) return 1 / x * myPow(1 / x, -(n + 1));
        if(n == 2) return x * x;

        if((n & 0x1) == 0) { // 注意 & 与 == 的优先级
            double t = myPow(x, n >> 1);
            return t * t;
        } else {
            double t = myPow(x, n >> 1);
            return x * t * t;
        }
    }
}
