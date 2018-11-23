package tag.design;

import java.util.HashMap;

class LFUCache {

    int capacity;
    HashMap<Integer, DataNode> dataMap;
    HashMap<Integer, FreqNode> freqMap;
    DoublyLinkedList freq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.freq = new DoublyLinkedList();
    }

    public int get(int key) {
        if(this.capacity <= 0) return -1;
        if(this.dataMap.containsKey(key)) {
            DataNode d = this.dataMap.get(key);
            hit(d);
            return d.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if(this.capacity <= 0) return;
        if(this.dataMap.containsKey(key)) {
            DataNode d = this.dataMap.get(key);
            hit(d);
            d.value = value;
        } else {
            if(this.dataMap.size() >= this.capacity) {
                FreqNode least = (FreqNode) this.freq.first();
                DataNode lru = (DataNode) least.data.removeLast();
                this.dataMap.remove(lru.key);
                if(least.data.isEmpty()) {
                    this.freq.remove(least);
                    this.freqMap.remove(least.freq);
                }
            }

            DataNode d = new DataNode(key, value);
            if(!this.freqMap.containsKey(1)) {
                FreqNode once = new FreqNode(1);
                this.freq.addFirst(once);
                this.freqMap.put(1, once);
            }
            FreqNode once = this.freqMap.get(1);
            once.data.addFirst(d);
            this.dataMap.put(key, d);
            d.freq = once;
        }
    }

    private void hit(DataNode d) {
        FreqNode oldFreq = d.freq;
        int f = oldFreq.freq;
        if(!this.freqMap.containsKey(f + 1)) {
            FreqNode fn = new FreqNode(f + 1);
            this.freqMap.put(f + 1, fn);
            this.freq.addAfter(fn, oldFreq);
        }

        FreqNode fn = this.freqMap.get(f + 1);
        oldFreq.data.remove(d);
        fn.data.addFirst(d);
        d.freq = fn;

        if(oldFreq.data.isEmpty()) {
            this.freq.remove(oldFreq);
            this.freqMap.remove(f);
        }
    }

    public static void main(String[] args) {
        LFUCache c = new LFUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        c.get(1);
        c.put(3, 3);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node {
    Node prev, next;
}

class DataNode extends Node{
    int key, value;
    FreqNode freq;

    DataNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class FreqNode extends Node{
    int freq;
    DoublyLinkedList data;

    FreqNode(int freq) {
        this.freq = freq;
        this.data = new DoublyLinkedList();
    }
}

class DoublyLinkedList {
    Node first, tail;

    DoublyLinkedList() {
        this.first = this.tail = new Node();
    }

    Node first() {
        return this.first.next;
    }

    Node last() {
        if(isEmpty()) return null;
        else return this.tail;
    }

    void addAfter(Node o, Node prev) {
        Node old = prev.next;
        prev.next = o;
        o.prev = prev;
        o.next = old;
        if(old != null) old.prev = o;
        if(old == null) this.tail = o;
    }

    void addFirst(Node o) {
        addAfter(o, this.first);
    }

    void remove(Node o) {
        o.prev.next = o.next;
        if(o.next != null) o.next.prev = o.prev;
        if(o.next == null) this.tail = o.prev;
        o.prev = o.next = null;
    }

    Node removeLast() {
        Node o = this.tail;
        remove(o);
        return o;
    }

    boolean isEmpty() {
        return this.first == this.tail;
    }
}