package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T146LRUCache {
	class Node {
		public int key;
		public int value;
		public Node prev;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public Node() {
		}
	}

	private Node head;
	private Node tail;
	private Map<Integer, Node> map;
	private int capacity;

	public T146LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;

		head = new Node();
		tail = new Node();
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
	}

	private void addNode(Node node) {
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;
	}
	
	private void deleteNode(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	
	private void deleteTail() {
		tail = tail.prev;
		deleteNode(tail.next);
	}
	
    public int get(int key) {
        if(!map.containsKey(key))
        		return -1;
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
    		if(map.containsKey(key)) {
    			deleteNode(map.get(key));
    		}
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
        if(map.size() > capacity) {
        		deleteTail();
        		map.remove(key);
        }
    }
}
