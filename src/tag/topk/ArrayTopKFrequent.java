package tag.topk;

import java.util.*;

public class ArrayTopKFrequent {
    // https://leetcode.com/problems/top-k-frequent-elements/description/
    public List<Integer> topKFrequent(int[] nums, int k) {
        // return priorityQueue(nums, k);
        return bucketSort(nums, k);
    }

    private List<Integer> priorityQueue(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> q
                = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int j = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(j < k) {
                q.offer(entry);
                j++;
            } else {
                if(entry.getValue() >= q.peek().getValue()) {
                    q.poll();
                    q.offer(entry);
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> entry = q.poll();
            ret.add(entry.getKey());
        }

        return ret;
    }

    private List<Integer> bucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int cnt = entry.getValue();
            if(bucket[cnt] == null) {
                bucket[cnt] = new LinkedList<>();
            }
            bucket[cnt].add(entry.getKey());
        }

        int c = 0;
        List<Integer> ret = new ArrayList<>();
        for(int i = nums.length; i > 0 && c < k; i--) {
            if(bucket[i] != null) {
                c += bucket[i].size();
                ret.addAll(bucket[i]);
            }
        }

        return ret;
    }
}