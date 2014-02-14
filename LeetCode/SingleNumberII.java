package LeetCode;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class SingleNumberII {
	public static int singleNumber(int A[]){
		Hashtable<Integer, Integer> all = new Hashtable<>();
		for(int i = 0 ; i < A.length;i++){
			if(!all.containsKey(A[i])){
				all.put(A[i], 1);
			} else {
				if(all.get(A[i]) == 1){
					all.put(A[i], 2);
				} else {
					all.remove(A[i]);
				}
			}
		}
		int n =0;
		Iterator i = all.entrySet().iterator();
        while(i.hasNext()){
            Entry<Integer, Integer> entry = (Entry) i.next();
            n = (Integer)entry.getKey();
        }
        return n;
	}
}
