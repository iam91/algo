package tag.unionfind;

public class FriendCircle {

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int n = M.length;
        int[] id = new int[n];
        for(int i = 0; i < n; i++) id[i] = i;

        int cnt = n;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(M[i][j] == 1) {
                    if(union(i, j, id)) {
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

    private int find(int x, int[] id) {
        int r = x;
        while(id[r] != r) {
            int t = r;
            r = id[r];
            id[t] = id[r];
        }
        return r;
    }

    private boolean union(int x, int y, int[] id) {
        int rx = find(x, id);
        int ry = find(y, id);
        if(rx == ry) return false;
        else {
            id[rx] = ry;
            return true;
        }
    }

    public static void main(String[] args) {
        FriendCircle c = new FriendCircle();
        int[][] M = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int n = c.findCircleNum(M);
    }
}
