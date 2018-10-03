package tag.design;

import java.util.HashMap;

public class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    public int get(int key) {
        Node n = hit(key);
        if(n != null) return n.value;
        return -1;
    }

    public void put(int key, int value) {
        Node n = hit(key);
        if(n != null) n.value = value;
        else {
            if(this.size >= this.capacity) {
                Node last = this.tail;
                this.tail = last.prev;
                this.tail.next = null;
                this.map.remove(last.key);
                this.size--;
            }

            Node newNode = new Node(key, value);
            this.map.put(key, newNode);

            addFirst(newNode);

            this.size++;
        }
    }

    private void addFirst(Node newNode) {
        if(this.head.next == null) {
            this.tail = newNode;
        } else {
            this.head.next.prev = newNode;
            newNode.next = this.head.next;
        }
        this.head.next = newNode;
        newNode.prev = this.head;
    }

    private Node hit(int key) {
        if(this.map.containsKey(key)) {
            Node node = this.map.get(key);

            if(node == this.tail) {
                this.tail = this.tail.prev;
                node.prev.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            addFirst(node);
            return node;
        } else return null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
    int key;
    int value;
    Node next, prev;

    Node () {}

    Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}