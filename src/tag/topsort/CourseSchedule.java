package tag.topsort;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    // https://leetcode.com/problems/course-schedule
    private int[][] g;
    private int n;
    private int[] visited;
    private int[] flag;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return canFinishDfs(numCourses, prerequisites);
        return canFinishKahn(numCourses, prerequisites);
    }

    private boolean canFinishKahn(int numCourses, int[][] prerequisites) {
        n = numCourses;
        g = new int[n][n];
        int[] d = new int[n];

        Queue<Integer> q = new LinkedList<>();

        int e = prerequisites.length;
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

        return e == 0;
    }

    private boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        n = numCourses;
        g = new int[n][n];
        visited = new int[n];
        flag = new int[n];

        int e = prerequisites.length;
        for(int i = 0; i < e; i++) {
            int[] edge = prerequisites[i];
            g[edge[1]][edge[0]] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) // 此处不判断回造成重复 dfs 超时
                if(!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int x) {
        if(flag[x] == 1) return false;
        if(visited[x] == 1) return true;
        flag[x] = 1;
        visited[x] = 1;
        for(int i = 0; i < n; i++) {
            if(g[x][i] > 0) {
                if(!dfs(i)) return false;
            }
        }
        flag[x] = 0;
        return true;
    }
}
