class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> keyToNodeMapping;

    public LRUCache(int capacity) {
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        this.capacity = capacity;
        this.keyToNodeMapping = new HashMap<>();
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(keyToNodeMapping.containsKey(key)) {
            ListNode node = keyToNodeMapping.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(!keyToNodeMapping.containsKey(key)) {
           if(keyToNodeMapping.size() >= capacity) {
               ListNode first = head.next;
               remove(first);
               keyToNodeMapping.remove(first.key);
           }

           ListNode node = new ListNode(key, value);
           keyToNodeMapping.put(key, node);
           add(node);
        }
        else {
            ListNode node = keyToNodeMapping.get(key);
            node.val = value;
            remove(node);
            add(node);
        }
    }

    private void add(ListNode node) {
        ListNode prev = tail.prev;
        node.prev = prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(ListNode node) {
        ListNode left = node.prev;
        ListNode right = node.next;
        left.next = right;
        right.prev = left;
        node.prev = null;
        node.next = null;
    }

    // private void print() {
    //     ListNode ptr = head;
    //     while(ptr!= null) {
    //     //    System.out.print(ptr.val + " -> ");
    //         ptr = ptr.next;
    //     }
    //    // System.out.println();
    // }
}

class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int val;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */