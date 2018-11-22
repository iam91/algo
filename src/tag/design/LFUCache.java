package tag.design;

import java.util.HashMap;

class LFUCache {

    int capacity;
    HashMap<Integer, DataNode> map;
    FreqNode head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new FreqNode(0);
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {
        if(this.map.containsKey(key)) {

        } else {
            if(this.map.size() >= this.capacity) {
                FreqNode least = leastFreq();
            }
        }
    }

    private FreqNode leastFreq() {
        FreqNode c = this.head;
        while(c.next != null) {
            if(c.next.first != c.next.tail) break;
            c = c.next;
        }
        return c.next;
    }

    private void addLast() {
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class DataNode {
    int key, value;
    DataNode prev, next;

    DataNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class FreqNode {
    int freq;
    FreqNode prev, next;
    DataNode first, tail;

    FreqNode(int freq) { this.freq = freq; }
}