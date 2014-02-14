package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Top_k {
	public static class LongString implements Comparable<Object>{
		Long longNum;
		String stringInfo;
		
		public LongString(Long l,String s){
			this.longNum = l;
			this.stringInfo = s;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			LongString comp = (LongString) o;
//			return longNum.compareTo(comp.longNum);
			return comp.longNum.compareTo(longNum);
		}

		
		
	}
	
	
	public static class FixedSizePriorityQueue<T extends Comparable<Object>>{
		private PriorityQueue<T> queue;
		private int maxSize;
		
		public FixedSizePriorityQueue(int maxSize){
			if(maxSize <= 0){
				throw new IllegalArgumentException();
			} else {
				this.maxSize = maxSize;
				this.queue = new PriorityQueue<T>(maxSize, new Comparator<T>() {

					@Override
					public int compare(T o1, T o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);
					}
				});
			}
		}
		
		public void add(T t){
			if(queue.size() < maxSize){
				queue.add(t);
			} else {
				T peekT = queue.peek();
				if(t.compareTo(peekT) < 0){
					queue.poll();
					queue.add(t);
				}
			}
		}
		
		public List sortedList() {
			List list = new ArrayList(queue);
			Collections.sort(list);
			return list;
		}
	}
	
	public static <K, V> Map<K, V> sortByValues(Map<K, V> map){
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Entry)it.next();
			
		}
		
		return map;
		
	}
	
	public List<Integer> slidWindow(int[] a, int windowSize){
		if(a.length < windowSize) throw new IllegalArgumentException();
		List<Integer> outoutList = new ArrayList<>();
		Map<Integer, Integer> keepIn = new TreeMap<Integer,Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1.compareTo(arg0);
			}	
		});
		
		for(int i = 0; i < a.length; i++){
			if(i < windowSize){
				keepIn.put(a[i], 0);
			} else{
				for(Object n :keepIn.keySet()){
					int m = (Integer) n;
					outoutList.add(m);
					break;
				}
				keepIn.remove(a[i - windowSize]);
				keepIn.put(a[i], 0);
			}
		}
		for(Object n :keepIn.keySet()){
			int m = (Integer) n;
			outoutList.add(m);
			break;
		}
		
		return outoutList;
	}
	
	public static void main(String[] args){
		 int[] A = {4,7,3,6,8,2,4,3,2,5,4}; 
		 String aString  = "23 323 3232 3232 323";
		 String[] strings = aString.split(" ");
		 for(String tmp: strings){
			 System.out.println(tmp);
		 }
		 Pattern 
		 LongString ff = new LongString((long) 110, "sfds");
		 LongString gg = new LongString((long) 111, "sfds");
//		 System.out.print(ff.compareTo(gg)+"ssfffffffffffffffffffffffffff");
		 FixedSizePriorityQueue<LongString> test11 = new FixedSizePriorityQueue<>(8);
		List<LongString> all = new ArrayList<>();
		all.add(gg);
		all.add(ff);
		for(int i = 1; i < 100; i++){
			LongString tmp = new LongString((long) i, "sfds");
			test11.add(tmp);
			all.add(tmp);
		}
		Collections.sort(all);
//		for(LongString each:all){
//			System.out.println(each.longNum+","+each.stringInfo);
//		}
		for(Object each1:test11.sortedList()){
			LongString eachLongString = (LongString)each1;
//			System.out.println(eachLongString.longNum+","+eachLongString.stringInfo);
		}
	}

}
