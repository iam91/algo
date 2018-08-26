package tag.math;

public class Sqrt {
    // https://leetcode.com/problems/sqrtx/description/
    public int mySqrt(int x) {
        // return binarySearch(x);
        return newton(x);
    }

    private int binarySearch(int x) {
        if(x <= 1) return x;
        else {
            int left = 0, right = x / 2 + 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(x / mid >= mid) left = mid + 1;
                else right = mid;
            }
            return right - 1;
        }
    }

    private int newton(int x) {
        if (x == 0) return 0;
        double res = 1, pre = 0;
        while (Math.abs(res - pre) > 1e-6) {
            pre = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
