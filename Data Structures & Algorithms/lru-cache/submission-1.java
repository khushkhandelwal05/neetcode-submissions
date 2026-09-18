public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node left;  // Sentinel for Least Recently Used (LRU)
    private Node right; // Sentinel for Most Recently Used (MRU)
    private int cap;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        
        // FIXED: Left points to Right initially
        left.next = right;
        right.prev = left;
    }

    // FIXED: Remap pointers around the node to isolate and extract it
    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // FIXED: Insert node right before the 'right' (MRU) sentinel node
    public void insert(Node node) {
        Node prevNode = right.prev;
        
        prevNode.next = node;
        node.prev = prevNode;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        // FIXED: Typo corrected from containksKey to containsKey
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node); // Refresh usage state
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key); // FIXED: Passing correct 'key' argument
            node.val = value;           // FIXED: Assigned 'value' instead of 'val'
            remove(node);
            insert(node);
            return;
        }
        
        // If cache capacity is hit, evict the LRU node (right after left sentinel)
        if (cache.size() == cap) { // FIXED: Use cache size checking against capacity
            Node lruNode = left.next;
            cache.remove(lruNode.key);
            remove(lruNode);
        }
        
        Node newNode = new Node(key, value); // FIXED: Fixed initialization arguments
        cache.put(key, newNode);
        insert(newNode); // FIXED: Typo corrected from inset to insert
    }
}
