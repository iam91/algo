package tag.topsort;

public class CourseScheduleII {
    int[][] g;
    int n;
    int t;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return findOrderDfs(numCourses, prerequisites);
    }

    private int[] findOrderDfs(int numCourses, int[][] pre) {
        t = 0;
        n = numCourses;
        g = new int[n][n];
        int[] visited = new int[n];
        int[] flag = new int[n];
        int[] ret = new int[n];

        for(int i = 0; i < pre.length; i++) {
            int[] edge = pre[i];
            g[edge[1]][edge[0]] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                if(!dfs(i, visited, flag, ret)) {
                    return null;
                }
            }
        }
        return ret;
    }

    private boolean dfs(int x, int[] visited, int[] flag, int[] ret) {
        if(flag[x] == 1) return false;
        flag[x] = 1;
        visited[x] = 1;
        ret[t++] = x;
        for(int i = 0; i < n; i++) {
            if(g[x][i] > 0) {
                if(!dfs(i, visited, flag, ret)) {
                    return false;
                }
            }
        }
        flag[x] = 0;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int n = 2;
        int[][] e = {{1, 0}};
        int[] r = c.findOrder(n, e);
    }
}
