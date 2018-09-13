package tag.backtracking;

import java.util.LinkedList;
import java.util.List;

// 看一个文件可以定义几个类
public class WordSearchII {
    // https://leetcode.com/problems/word-search-ii/description/

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if(board == null || board.length == 0 || board[0].length == 0) return res;

        TrieNode root = buildTree(words);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, TrieNode root, int x, int y, List<String> res) {
        char curr = board[x][y];
        if(curr == '#' || root.next[curr - 'a'] == null) return;
        root = root.next[curr - 'a'];
        if(root.word != null) {
            res.add(root.word);
            root.word = null; // prevent duplication
        }

        board[x][y] = '#';
        if(x > 0) dfs(board, root, x - 1, y, res);
        if(x < board.length - 1) dfs(board, root, x + 1, y, res);
        if(y > 0) dfs(board, root, x, y - 1, res);
        if(y < board[0].length - 1) dfs(board, root, x, y + 1, res);
        board[x][y] = curr;
    }

    TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        for(String w: words) {
            TrieNode curr = root;
            for(char ch: w.toCharArray()) {
                int idx = ch - 'a';
                if(curr.next[idx] == null) curr.next[idx] = new TrieNode();
                curr = curr.next[idx];
                sb.append(ch);
            }
            curr.word = sb.toString();
            sb.delete(0, sb.length());
        }

        return root;
    }

    public static void main(String[] args) {
        WordSearchII c = new WordSearchII();

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        c.findWords(board, words);
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
