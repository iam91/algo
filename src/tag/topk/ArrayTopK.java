package tag.topk;

import java.util.*;

public class ArrayTopK {
    // https://leetcode.com/problems/kth-largest-element-in-an-array/description/
    public int findKthLargest(int[] nums, int k) {
        int i;
        int n = nums.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(i = 0; i < k; i++) {
            q.offer(nums[i]);
        }
        
        for(; i < n; i++) {
            if(nums[i] >= q.peek()) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        
        return q.poll();
    }
}