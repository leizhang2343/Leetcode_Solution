package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	 public static void main(String[] args){
		 
//		 String  s  = "bccdbacdbdacddabbaaaadababadad";
//		 String s = "applepie";
		 String s = "aaaaaaa";
		 ArrayList<ArrayList<String>> all  = new ArrayList<ArrayList<String>> ();
//		 getPow(all,s);
		 
//		 String[] dict ={"pear","apple","peach"};
		 String[] dict ={"aaaa","aa"};
//		 String[] dict = {"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"};
		Set<String> set = new HashSet<String>();
		for(String sss: dict){
			set.add(sss);
		}
		long start = System.currentTimeMillis();
		System.out.println(wordBreak(s, set));
		System.out.println(System.currentTimeMillis() - start);
//		 for(ArrayList<String> oneSet:all){
//			 System.out.println();
//			 for(String tmp : oneSet){
//				 System.out.print(tmp+" ");
//			 }
//		 }
	 }
	
//	 public static ArrayList<ArrayList<String>> getPow(ArrayList<ArrayList<String>> all, String s){
//		 ArrayList<ArrayList<String>> allSet = new ArrayList<ArrayList<String>>();
//		 int length = s.length()-1;
//		 int max = 1<<length+1;
//		 for(int i = 1<<length; i < max;i++ ){
////			 System.out.println("i= "+i);
//			 ArrayList<String> subset =  getSubset(i,s);
////			 System.out.println();
//			 all.add(subset);
//		 }
//		 return allSet;
//	 }
	 
//	 public static  ArrayList<String> getSubset(int n,String s) {
//		 ArrayList<String> subset = new ArrayList<String>();
//		 int begin = 0;
//		 int index = 1;
//		 for(int k = n; k >0; k >>=1){
//			 if((k&1)==1){
//				 subset.add(s.substring(begin, index));
//				 begin = index;
//			 }
//			 index++;
//		 }
////		 for(String tmp : subset){
////			 System.out.print(tmp+" ");
////		 }
//		 return subset;
//	}
	 
	 public static boolean wordBreak(String s, Set<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 
		 //String sNew = greedSort(s, dict);
		 while(s.length()>1){
			 String newS = greedSort(s, dict);
			 if(newS.length() == s.length()){
			    return false;
			 } else{
			     s = newS;
			 }
		 }
		 if(s==""){
			 return true;
		 }
		 while(s.length()>1){
			 s = greedSort(s, dict);
		 }
		 if(s==""){
			 return true;
		 }
		 int length = s.length()-1;
		 int max = 1<<length+1;
		 for(int i = 1<<length; i < max;i++ ){
			  if(getPow(i,s,dict)){
			      return true;
			  }
		 }
		 return false;
	    }
	    public static boolean getPow(Integer n, String s,Set<String> dict){
	    	int begin = 0;
			 int index = 1;
			 for(int k = n; k >0; k >>=1){
				 if((k&1)==1){
				     String tmp = s.substring(begin, index);
				     if(!dict.contains(tmp)){
				         return false;
				     }
					 begin = index;
				 }
				 index++;
			 }
			 return true;
	    }
	    
	    public static String greedSort(String s,Set<String> dict) {
	    	    int length = s.length();
	    		int begin = 0;
	    		int end = length-1;
	    		if(dict.contains(s)) return "";
	    		for(int i=0;i<length-1;i++){
	    			System.out.println(s+"   \nb:"+begin+"e:"+end);
	    			if(dict.contains(s.substring(0, i))){
	    				begin = i;
	    			    }
	    			}
	    		for(int j = length-1;j>=begin;j--){
	    			if(dict.contains(s.substring(j, length))){
	    				   end = j;
	    				}
	    			 }
	    			 if(begin >= end){
	    			     return "";
	    			 }
	    			System.out.println(s+"   \nb:"+begin+"e:"+end);
	    		return s.substring(begin, end);
	    	}
}
