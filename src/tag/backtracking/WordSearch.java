package tag.backtracking;

public class WordSearch {
    // https://leetcode.com/problems/word-search/description/
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int deep, int x, int y, boolean[][] visited) {
        if(word.charAt(deep) != board[x][y]) return false;
        else if(deep + 1 == word.length()) return true;

        visited[x][y] = true;
        if(x > 0 && !visited[x - 1][y]) {
            if(dfs(board, word, deep + 1, x - 1, y, visited)) return true;
        }
        if(x < board.length - 1 && !visited[x + 1][y]) {
            if(dfs(board, word, deep + 1, x + 1, y, visited)) return true;
        }
        if(y > 0 && !visited[x][y - 1]) {
            if(dfs(board, word, deep + 1, x, y - 1, visited)) return true;
        }
        if(y < board[0].length - 1 && !visited[x][y + 1]) {
            if(dfs(board, word, deep + 1, x, y + 1, visited)) return true;
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch c = new WordSearch();

        char[][] board = {{'a'}};
        String word = "a";

        System.out.println(c.exist(board, word));
    }
}
