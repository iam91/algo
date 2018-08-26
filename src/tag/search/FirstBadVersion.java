package tag.search;

public class FirstBadVersion {
    // https://leetcode.com/problems/first-bad-version/description/

    private static int first = 4;

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean isBadVersion(int x) {
        return x >= first;
    }
}
