package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakQiuShuo {
	public ArrayList<ArrayList<String>> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<String> alreadyHave = new ArrayList<>();
	        ArrayList<ArrayList<String>> all = new ArrayList<>(); 
        if(s==null||s.length()<1)
            return all;
        if(dict.size()<1)
            return all;
        int[] dp = new int[s.length()];
        wordBreakRecursive(s,dict,0,alreadyHave,all,dp);
        for(ArrayList<String> tmp: all){
        	System.out.println(tmp);
        }
        return all;
    }
	
    boolean wordBreakRecursive(String s, Set<String> dict,int start,ArrayList<String> alreadyHave,ArrayList<ArrayList<String>> all,int[] dp){
        if (start==s.length()){
        	ArrayList<String> tmpArr = new ArrayList<>();
        	for(String s1 : alreadyHave){
        		tmpArr.add(s1);
        	}
        	all.add(tmpArr);	
        	return true;
        }	
        if(dp[start] == 2){
//        	return false;
        }
        for(int i=s.length();i>start;i--){
            if(dict.contains(s.substring(start,i))){
            	alreadyHave.add(s.substring(start,i));
            	if(wordBreakRecursive(s,dict,i,alreadyHave,all,dp)){
//            		break;
            	}
            	alreadyHave.remove(alreadyHave.size()-1);
            }
        }
        dp[start] = 2;
        return false;
    }
    public static void main(String[] args) {
    	 Set<String> dit = new HashSet<>();
    	 dit.add("A");
    	 dit.add("B");
    	 dit.add("BA");
    	 dit.add("AB");
    	 dit.add("AAA");
    	 dit.add("BB");
    	 String s = "BBAAABB";
    	 WordBreakQiuShuo testBreakQiuShuo = new WordBreakQiuShuo();
    	testBreakQiuShuo.wordBreak(s,dit);
	} 
}
