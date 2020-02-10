package medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheWithLinkedHashMap cache = new LRUCacheWithLinkedHashMap(2);
		cache.get(2);       
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);    // evicts key 2
		cache.put(1, 2);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(2);       // returns 3
		
	}
	Map<Integer, Integer> cache;
    int cacheCapacity;
    public LRUCacheWithLinkedHashMap(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity);
        this.cacheCapacity = capacity;
    }
    public int get(int key) {
        int res= -1;
        if(cache.containsKey(key)){
            res = cache.get(key);
            cache.remove(key);
            cache.put(key, res);
        }
        return res;
    }
    
    public void put(int key, int value) {
    	 if(cache.containsKey(key)){
             cache.remove(key);
             cache.put(key, value);
         }else if(cache.size() == cacheCapacity){
             int elementToRemove = cache.entrySet().iterator().next().getKey();
             cache.remove(elementToRemove);
              cache.put(key,value);
         }else{
            cache.put(key,value);            
         }
            
    }

}
