package tag.search;

public class SearchMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/description/

    private int m;
    private int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        this.m = matrix.length;
        this.n = matrix[0].length;

        int left = 0, right = m * n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[x(mid)][y(mid)];
            if(midVal == target) return true;
            else if(midVal > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    private int x(int idx) {
        return idx / this.n;
    }

    private int y(int idx) {
        return idx % this.n;
    }
}
