package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class PartitionPalindrome {
    public ArrayList<ArrayList<String>>  partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	HashMap<String,Boolean> checkResult = new HashMap<>();
    	System.out.println(checkPalindrome(s,checkResult));
		System.out.println(recursionPalindrome(s,checkResult));
        return null;
    }
    
    public static void getAllPartition(String s) {
		int length = s.length();
		int max = 1<<length; //Comput 2^n
		int n = 0;
		for(int k = 0;k < max>>1;k++){
			System.out.println(Integer.toBinaryString(k));
			int ni = 0;
			for(int ki = k;ki > 0;ki >>= 1){
				if((ki & 1) == 1){
					System.out.print("ni:"+ni);
					
				}
				ni++;
			}
			System.out.println();
			System.out.println(n++);
		}
	}
    
    public static boolean recursionPalindrome(String s,HashMap<String, Boolean> checkResult) {
    	
    	if(checkPalindrome(s,checkResult)){
    		return true;
    	} else {
    		for(int i = 1; i < s.length();i++){
    			System.out.println(s.substring(0, i)+" " + s.substring(i));
    			if(checkPalindrome(s.substring(0, i),checkResult)&&recursionPalindrome(s.substring(i),checkResult)){
    				return true;
    			}
    		}
    	return false;
    	}
	}
    
    public static boolean checkPalindrome(String s,HashMap<String,Boolean> checkResult) {
    	if(s.length() < 2){
    		return true;
    	} else {
    		if(!checkResult.containsKey(s)){
    			for(int i = 0,j=s.length()-1; i < j ;i++,j--){
    				System.out.println(s.charAt(i)+" "+s.charAt(j));
    				if(s.charAt(i)!=s.charAt(j)){
    					return false;
    				}
    			}
    		}
		}
    	checkResult.put(s, true);
		return true;
	}
    
    public static void main(String[] args) {
    	String s = "765454567";
		for(int i = 1; i < s.length(); i++){
			
		}
		
		getAllPartition("rewrew");
	}
    
}
