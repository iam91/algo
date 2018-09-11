package tag.search;

public class SearchMatrixII {
    // https://leetcode.com/problems/search-a-2d-matrix-ii/description/

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = n - 1, y = 0;
        while(x >= 0 && y < m) {
            if(matrix[y][x] == target) return true;
            else if(matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrixII c = new SearchMatrixII();

//        int[][] matrix = {
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};
//        int target = 20;
        int[][] matrix = {{1, 1}};
        int target = 0;

        System.out.println(c.searchMatrix(matrix, target));
    }
}
