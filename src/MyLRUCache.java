import java.util.HashMap;

public class MyLRUCache {
    class DLinkedNode {
        int key;
        String value;
        DLinkedNode pre;
        DLinkedNode next;
        DLinkedNode(){}
        DLinkedNode(int _key,String _value){key = _key; value = _value;}
    }
    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;
    HashMap<Integer,DLinkedNode> cache;

    MyLRUCache(int _capacity){
        capacity = _capacity;
        size = 0;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    String get(int key){
        if (cache.get(key) == null) return null;
        moveToHead(cache.get(key));
        return cache.get(key).value;
    }
    void put(int key,String value){
        if (cache.get(key) != null){
            cache.get(key).value = value;
            moveToHead(cache.get(key));
        } else {
            DLinkedNode node = new DLinkedNode(key,value);
            addToHead(node);
            cache.put(key,node);
            size++;
            if (size > capacity){
                DLinkedNode lastNode = getLastNode();
                remove(lastNode);
                cache.remove(lastNode);
            }
        }
    }

    void addToHead(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    void moveToHead(DLinkedNode node){
        remove(node);
        addToHead(node);
    }

    void remove(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    DLinkedNode getLastNode() {
        return tail.pre;
    }

}
