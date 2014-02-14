package LeetCode;

import java.util.ArrayList;
import java.util.Set;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	for(int i = 0; i < s.length(); i++){
    		
    	}
        
    	return null;
    }
    
    public void palindromePartitioningRecursive(String s,ArrayList<String> part){

    }
    
    public boolean palindromeCheck(){
		return false;
    }
    
    
public static ArrayList<ArrayList<String>> getPow(ArrayList<ArrayList<String>> all, String s){
	 ArrayList<ArrayList<String>> allSet = new ArrayList<ArrayList<String>>();
	 int length = s.length()-1;
	 int max = 1<<length+1;
	 for(int i = 1<<length; i < max;i++ ){
		 System.out.println("i= "+i);
		 System.out.println(Integer.toBinaryString(i));
		 ArrayList<String> subset =  getSubset(i,s);
		 System.out.println();
		 all.add(subset);
	 }
	 return allSet;
}

public static  ArrayList<String> getSubset(int n,String s) {
	 ArrayList<String> subset = new ArrayList<String>();
	 int begin = 0;
	 int index = 1;
	 for(int k = n; k >0; k >>=1){
		 if((k&1)==1){
			 subset.add(s.substring(begin, index));
			 begin = index;
		 }
		 index++;
	 }
	 for(String tmp : subset){
		 System.out.print(tmp+" ");
	 }
	 return subset;
}

    
    public static void main(String[] args){
    	String s = "abcde";
//    	System.out.print(s.substring(0, 2));
//    	System.out.print(s.substring(2));
    	ArrayList<ArrayList<String>> allSet = new ArrayList<ArrayList<String>>();
    	getPow(allSet,s);
    	
    }
    
}
