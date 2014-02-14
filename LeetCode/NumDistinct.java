package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class NumDistinct {
    public int numDistinct(String S, String T) {
    	
    	ArrayList<String> sSubsA = getSubsequencesA(S, 0);
    	ArrayList<String> tSubsA = getSubsequencesA(T, 0);
    	HashSet<String> all = new HashSet<>();
    	for(String s: sSubsA){
    		all.add(s);
    	}
    	for(String t:tSubsA){
    		all.remove(t);
    	}
		return all.size();
        
    }
    
    ArrayList<String> getSubsequencesA(String S,int index){
    	ArrayList<String> allSubs;
        if(index == S.length()){
            allSubs = new ArrayList<String>();
            allSubs.add("");
        }else{
            allSubs = getSubsequencesA(S,index + 1);
            char tmp = S.charAt(index);
            ArrayList<String> moreSubs = new ArrayList<String>();
            for(String subString : allSubs){
                String newSubString = subString+tmp;
                moreSubs.add(newSubString);
            }
            allSubs.addAll(moreSubs);
        }
        return allSubs;
    }
    
    HashSet<String> getSubsequences(String S,int index){
        HashSet<String> allSubs;
        if(index == S.length()){
            allSubs = new HashSet<String>();
            allSubs.add("");
        }else{
            allSubs = getSubsequences(S,index + 1);
            char tmp = S.charAt(index);
            HashSet<String> moreSubs = new HashSet<String>();
            for(String subString : allSubs){
                String newSubString = subString+tmp;
                moreSubs.add(newSubString);
            }
            allSubs.addAll(moreSubs);
        }
        return allSubs;
    }
    
    public int numDistinctQiuShuo(String S, String T) {
        if(S==null||T==null||S.length()<T.length())
            return 0;
        int[][] result=new int[S.length()][T.length()];
        return numDistinctRecursive(S,T,0,0,result);
    }
    int numDistinctRecursive(String S,String T,int s1,int t1,int[][] result){
        if(t1>=T.length())
            return 1;
        if(s1>=S.length())
            return 0;
        if(result[s1][t1]!=0)
            return result[s1][t1]-1;
        int temp=s1;
        while(temp<S.length()&&S.charAt(temp)!=T.charAt(t1))
            temp++;
        if(temp==S.length())
            result[s1][t1]=1;
        else
            result[s1][t1]=1+numDistinctRecursive(S,T,temp+1,t1+1,result)+numDistinctRecursive(S,T,temp+1,t1,result);
        return result[s1][t1]-1;
    }

    
    public static void main(String[] args) {
    	NumDistinct test = new NumDistinct();
    	
//    	for(String s:test.getSubsequences("rabbit", 0)){
//    		System.out.print(s +",");
//    	}
    	System.out.println();
    	for(String s:test.getSubsequencesA("54321", 0)){
    		System.out.print(s +",");
    	}
    	System.out.println();
    	for(String s:test.getSubsequencesA("tibbar", 0)){
    		System.out.print(s +",");
    	}
    	System.out.println();	
    	System.out.println(test.numDistinct("tibbbar", "tibbar"));
    	System.out.println(test.numDistinctQiuShuo("tibbbar", "tibbar"));
	}
}
