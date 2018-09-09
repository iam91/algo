package tag;

import java.util.Scanner;
public class Main1 {

    private static int find(int[] parents, int i) {
        int r = parents[i];
        while(r != parents[r]) {
            r = parents[r];
        }
        return r;
    }

    private static boolean solve(boolean[][] g, int N, int M) {
        int[] parents = new int[N];

        for(int i = 0; i < N; i++) parents[i] = i;

        for(int i = 0; i < N; i++) {
            int r = find(parents, i);

            for(int j = 0; j < N; j++) {
                if(!g[i][j]) {
                    parents[find(parents, j)] = r;
                }
                if(g[i][j]) {
                    continue;
                }
                parents[find(parents, j)] = r;
            }

            for(int j = 0; j < N; j++) {
                if(!g[i][j] || i == j) continue;
                if(find(parents, j) == r) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        while(T-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            boolean[][] g = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    g[i][j] = i == j;
                }
            }
            for(int i = 0; i < M; i++) {
                int from = scan.nextInt() - 1;
                int to = scan.nextInt() - 1;
                g[from][to] = g[from][to] = true;
            }
            System.out.println(solve(g, N, M) ? "Yes" : "No");
        }

        scan.close();
    }
}