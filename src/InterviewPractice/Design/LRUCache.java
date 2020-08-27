package InterviewPractice.Design;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

/**
 *  Solution 1:
 *  Hashmap + DoubleLinkedList
 *
 *  Solution 2:
 *  LinkedHashMap
 *
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    /*This method will delete node*/
    public void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }

    }

    /*This method will make passed node as head*/
    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (end == null)
            end = head;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // update the old value
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {

                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newNode);

            } else {
                setHead(newNode);
            }

            map.put(key, newNode);
        }
    }

    public static void main(String[] args){
        LRUCache lrucache = new LRUCache(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));

    }
}

/*
LinkedHashMap implementation

Several points to mention:

In the constructor, the third boolean parameter specifies the ordering mode. If we set it to true, it will be in access order. (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-)
By overriding removeEldestEntry in this way, we do not need to take care of it ourselves. It will automatically remove the least recent one when the size of map exceeds the specified capacity.(https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)

*/

class LRUCache2 {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache2(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }
}


