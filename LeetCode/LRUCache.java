package LeetCode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;


public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer,Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key)){
    		return -1;
    	} else {
    		int value = cache.get(key);
    		cache.remove(key);
    		cache.put(key, value);
    		return value;
    	}
        
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
        	cache.put(key, value);
        } else{
        	if(cache.size() >= capacity){
        		Set<Integer> tmp = cache.keySet();
        		Iterator<Integer> tmpIterator = tmp.iterator();
        		cache.remove(tmpIterator.next());
        	}
        	cache.put(key, value);
        }
    }
}
