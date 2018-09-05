package tag.array;

import java.util.*;

public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        // return findBySort(nums);
        // return findBySet(nums);
        return findByUnionFind(nums);
    }

    private int findByUnionFind(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int m = 0;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], m++);
            }
        }

        int[] id = new int[m];
        int[] sz = new int[m];
        for(int i = 0; i < m; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        int max = 1;
        for(int num: map.keySet()) {
            int idx = map.get(num);
            if(map.containsKey(num - 1)) {
                max = Math.max(max, union(id, sz, idx, map.get(num - 1)));
            }
            if(map.containsKey(num + 1)) {
                max = Math.max(max, union(id, sz, idx, map.get(num + 1)));
            }
        }

        return max;
    }

    private int union(int[] id, int[] sz, int x, int y) {
        int rx = find(id, x);
        int ry = find(id, y);
        if(rx == ry) return 0;
        else {
            id[rx] = ry;
            sz[ry] += sz[rx];
            return sz[ry];
        }
    }

    private int find(int[] id, int x) {
        int r = x;
        while(id[r] != r) {
            int t = id[r];
            id[r] = id[t];
            r = t;
        }
        return r;
    }

    private int findBySet(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(nums[i]);

        int max = Integer.MIN_VALUE;
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int next = num + 1;
                int len = 1;

                while(set.contains(next)) {
                    next++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }

    private int findBySort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int len = 1;
        int next = nums[0] + 1;
        int max = len;
        for(int i = 1; i < n; i++) {
            if(nums[i] == next) {
                len++;
                next++;
            }
            if(i == n - 1 || nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1) {
                max = Math.max(max, len);
                len = 1;
                next = nums[i] + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence c = new LongestConsecutiveSequence();
        int[] nums = {0,0,-1};
        int t = c.longestConsecutive(nums);
    }
}
