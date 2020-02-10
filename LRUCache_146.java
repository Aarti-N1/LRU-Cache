package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	  Map<Integer, Node> cache ;
	    Node head;
	    Node tail;
	    int cacheCapacity;
	    public LRUCache_146(int capacity) {
	        head=new Node();
	        tail= new Node();
	        head.next = tail;
	        tail.prev= head;
	        cache = new HashMap<Integer, Node>(capacity);
	        cacheCapacity=capacity;
	    }
	    
	    public int get(int key) {
	        int res = -1;
	        //return val or -1
	        if(cache.containsKey(key)){
	            Node node = cache.get(key);
	            res = node.val;
	            remove(node);
	            add(node);
	        }
	        return res;
	        //shift node to head
	    }
	    
	    public void put(int key, int value) {
	        if(cache.containsKey(key)){
	            Node node = cache.get(key);
	            node.val = value;
	            remove(node);
	            add(node);
	        }else{
	            if(cache.size() == cacheCapacity){
	                cache.remove(tail.prev.key);
	                remove(tail.prev);
	            }
	            Node node = new Node(key, value);
	            add(node);
	            cache.put(key, node);
	        }
	        //check if node already exists ->shift to start
	        //if capacity is full remove tail
	    }
	    
	    public void add(Node node){
	        //add the node to head of ll
	        Node headNext = head.next;
	        head.next = node;
	        node.prev= head;
	        node.next= headNext;
	        headNext.prev = node;
	    }
	    public void remove(Node node){
	        // remove node from ll
	        Node prevNode = node.prev;
	        Node nextNode = node.next;
	        prevNode.next = nextNode;
	        nextNode.prev = prevNode;
	    }
	    
	    class Node{
	        int key;
	        int val;
	        Node prev;
	        Node next;
	        public Node(){}
	        public Node(int key, int val){
	            this.key= key;
	            this.val = val;
	        }
	    }

}
