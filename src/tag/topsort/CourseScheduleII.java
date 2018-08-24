package tag.topsort;

import java.util.*;

public class CourseScheduleII {
    // https://leetcode.com/problems/course-schedule-ii
    int[][] g;
    int[] ret;
    int n;
    int t;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // return findOrderDfs(numCourses, prerequisites);
        return findOrderKahn(numCourses, prerequisites);
    }

    private int[] findOrderKahn(int numCourses, int[][] prerequisites) {
        t = 0;
        n = numCourses;
        g = new int[n][n];
        ret = new int[n];

        int[] d = new int[n];
        int e = prerequisites.length;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < e; i++) {
            int[] edge = prerequisites[i];
            g[edge[1]][edge[0]] = 1;
            d[edge[0]]++;
        }

        for(int i = 0; i < n; i++) {
            if(d[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int c = q.poll();
            ret[t++] = c;
            for(int i = 0; i < n; i++) {
                if(g[c][i] > 0) {
                    d[i]--;
                    e--;
                    if(d[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        if(e == 0) {
            return ret;
        } else {
            return new int[0];
        }
    }

    private int[] findOrderDfs(int numCourses, int[][] prerequisites) {
        t = 0;
        n = numCourses;
        g = new int[n][n];
        ret = new int[n];
        int[] visited = new int[n];
        int[] flag = new int[n];

        int e = prerequisites.length;
        for(int i = 0; i < e; i++) {
            int[] edge = prerequisites[i];
            g[edge[1]][edge[0]] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) // 此处不判断回造成重复 dfs 超时
                if(!dfs(i, visited, flag)) return new int[0];
        }

        int i = 0, j = n - 1;
        while(i < j) {
            int tt = ret[i];
            ret[i] = ret[j];
            ret[j] = tt;
            i++;
            j--;
        }
        return ret;
    }

    private boolean dfs(int x, int[] visited, int[] flag) {
        if(flag[x] == 1) return false;
        if(visited[x] == 1) return true;
        flag[x] = 1;
        visited[x] = 1;
        for(int i = 0; i < n; i++) {
            if(g[x][i] > 0) {
                if(!dfs(i, visited, flag)) return false;
            }
        }
        flag[x] = 0;
        ret[t++] = x;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int n = 2;
        int[][] e = {{1, 0}};
        int[] r = c.findOrder(n, e);
    }
}
