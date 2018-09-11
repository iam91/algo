package tag.search;

public class SearchMatrixII {
    // https://leetcode.com/problems/search-a-2d-matrix-ii/description/

    private int m;
    private int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        this.m = matrix.length;
        this.n = matrix[0].length;


        return false;
    }

    private int x(int idx) {
        return idx / this.n;
    }

    private int y(int idx) {
        return idx % this.n;
    }
}
