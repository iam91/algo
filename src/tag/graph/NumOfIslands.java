package tag.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
    // https://leetcode.com/problems/number-of-islands/description/
    private char[][] grid;
    private int n;
    private int m;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    // bfs
    // Time limit exceeded on test case 38/47
    // O(mn*mn)
    private Queue<Integer> qx;
    private Queue<Integer> qy;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        if(this.grid == null) return 0;
        this.n = grid.length;
        if(this.n == 0) return 0;
        this.m = grid[0].length;
        if(this.m == 0) return 0;

        // return computeByBfs();
        return computeByDfs();
    }

    private int computeByDfs() {
        int cnt = 0;
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.m; j++) {
                if(this.grid[i][j] == '1') {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int cx, int cy) {
        this.grid[cx][cy] = '2';
        for(int i = 0; i < 4; i++) {
            int tx = cx + dx[i];
            int ty = cy + dy[i];
            if(tx >= 0 && tx < this.n && ty >= 0 && ty < this.m && this.grid[tx][ty] == '1') {
                dfs(tx, ty);
            }
        }
    }

    private int computeByBfs() {
        this.qx = new LinkedList<>();
        this.qy = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.m; j++) {
                if(this.grid[i][j] == '1') {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(int x, int y) {
        this.qx.offer(x);
        this.qy.offer(y);
        while(!this.qx.isEmpty()) {
            int cx = this.qx.poll();
            int cy = this.qy.poll();
            this.grid[cx][cy] = '2';
            for(int i = 0; i < 4; i++) {
                int tx = cx + dx[i];
                int ty = cy + dy[i];
                if(tx >= 0 && tx < this.n && ty >= 0 && ty < this.m && this.grid[tx][ty] == '1') {
                    this.qx.offer(tx);
                    this.qy.offer(ty);
                }
            }
        }
    }
}
