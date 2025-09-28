class LRUCache {
    class Node {
        int key ,value;
        Node prev,next;
        Node(int k, int v){
            key = k;
            value= v;
        }
    }
        private Map<Integer,Node> map;
        private int capacity;
        private Node head,tail;

    public LRUCache(int capacity) {
        this.capacity =  capacity;
        this.map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next =tail;
        tail.prev =head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)) {
        Node node = map.get(key);
        node.value =value;
        remove(node);
        insertToHead(node);
         }else{
            if(map.size()==capacity){
                Node lru= tail.prev;
                remove(lru);
                map.remove(lru.key);

            }
            Node node  = new Node(key,value);
            insertToHead(node);
            map.put(key,node);
         }
         }
         private void remove(Node node){
            node.prev.next = node.next;
            node.next.prev =node.prev;

         }
         private void insertToHead(Node node){
            node.next = head.next;
            head.next.prev= node;
            head.next = node;
            node.prev = head;

         }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */