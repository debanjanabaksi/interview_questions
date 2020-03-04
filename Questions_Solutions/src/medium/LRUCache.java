package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	static CacheNode head;
	static CacheNode tail;
	Map<Integer,CacheNode> map ;
	int capacity;
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1);
		cache.put(2);
		cache.put(3);
		display();
		cache.put(4);
		display();
		cache.put(5);
		display();
		cache.get(3);
		cache.put(6);
		display();

	}
	LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	private static class CacheNode  
	{
		
		int value;
		CacheNode prev;
		CacheNode next;
		
		CacheNode(int value) {
			this.value = value;
			
			prev = null;
			next = null;
		}
		
	}
	
	private int get(int key) {
		if(map.get(key) == null) {
			return -1;
		}
		CacheNode n = map.get(key);
		int val = n.value;
		remove(n);
		add(n);
		return val;
	}
	
	private void put(int key) {
		if (map.get(key)!=null) {
			CacheNode n = map.get(key);
			n.value = key;
			remove(n);
			add(n);
		} else if(map.size()>=capacity) {
			
			int key2 = head.value;
			map.remove(key2);
			remove(head);
		} 
		
			CacheNode newNode = new CacheNode(key);
			add(newNode);
			map.put(key, newNode);
			
		
	}
	
	private static void add(CacheNode n) {
		if(tail!=null) {
			tail.next = n;
			
		}
		 n.prev= tail;
		 tail = n;	
		 if (head == null) {
				head = tail;
			}
	}
	
	private static void remove(CacheNode n) {
		if(head == tail) {
			head = null;
			tail = null;
			return;
		}
		if(n.prev == null) {
			head = n.next;
			head.prev = null;
		} else {
			n.prev.next = n.next;
		}
		if(n == tail) {
			tail = n.prev;
			tail.next = null;
		}
	}
	
	private static void  display() {
		CacheNode temp = head;
		while(temp!=null) {
			System.out.print(" "+temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
}
