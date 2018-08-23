package tag.topk;

import java.util.*;

public class TopKFrequentWord {
    // https://leetcode.com/problems/top-k-frequent-words/description/
    public List<String> topKFrequent(String[] words, int k) {
        return priorityQueue(words, k);
    }

    private List<String> priorityQueue(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> q
                = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int freq = o1.getValue() - o2.getValue();
                return freq == 0 ? -o1.getKey().compareTo(o2.getKey()) : freq;
            }
        });

        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int i = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(i < k) {
                q.offer(entry);
                i++;
            } else {
                if(entry.getValue() > q.peek().getValue()) {
                    q.poll();
                    q.offer(entry);
                } else if(entry.getValue() == q.peek().getValue()) {
                    if(entry.getKey().compareTo(q.peek().getKey()) < 0) {
                        q.poll();
                        q.offer(entry);
                    }
                }
            }
        }

        LinkedList<String> ret = new LinkedList<>();
        while(!q.isEmpty()) {
            ret.addFirst(q.poll().getKey());
        }

        return ret;
    }
}
