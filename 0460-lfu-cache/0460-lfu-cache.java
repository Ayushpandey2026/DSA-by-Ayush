import java.util.*;

class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                removeNode(last);
                return last;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (nodeMap.size() == capacity) {
                // remove LFU
                DoublyLinkedList list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                nodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        }
    }

    private void updateNode(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}
