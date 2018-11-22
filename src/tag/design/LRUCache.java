package tag.design;

import java.util.HashMap;

class LRUCache {

    int capacity;

    LRUNode head, last;
    HashMap<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = this.last = new LRUNode();
    }

    public int get(int key) {
        if(this.map.containsKey(key)) {
            LRUNode o = this.map.get(key);
            remove(o);
            addLast(o);
            return o.value;
        } else return -1;
    }

    public void put(int key, int value) {
        LRUNode o;
        if(this.map.containsKey(key)) {
            o = this.map.get(key);
            o.value = value;
            remove(o);
            addLast(o);
        } else {
            if(this.map.size() >= this.capacity) {
                LRUNode t = removeFirst();
                this.map.remove(t.key);
            }
            o = new LRUNode(key, value);
            this.map.put(key, o);
            addLast(o);
        }
    }

    private void remove(LRUNode o) {
        o.prev.next = o.next;
        if(o.next != null) o.next.prev = o.prev;
        if(o == this.last) this.last = o.prev;
        o.next = o.prev = null;
    }

    private LRUNode removeFirst() {
        LRUNode o = this.head.next;
        if(o != null) remove(o);
        // 返回被淘汰元素方便获取key，从HashMap中删除
        return o;
    }

    private void addLast(LRUNode o) {
        this.last.next = o;
        o.prev = this.last;
        this.last = o;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUNode {
    int key;
    int value;
    LRUNode next, prev;

    LRUNode() {}

    LRUNode(int key, int val) {
        this.key = key;
        this.value = val;
    }
}