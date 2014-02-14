package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

import Chapter_9.Robot;

public class Combine {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> combine = new ArrayList<ArrayList<Integer>>();
        HashSet<HashSet<Integer>> check = new HashSet<HashSet<Integer>>();
        HashSet<Integer> chosen = new HashSet<Integer>();
        if( k > n/2 ){
        	for(int i = 1;i <= n;i++){
        		chosen.add(i);
        	}
        	 getRandomSub(combine,check,n,k,chosen);
        } else {
        	
        	 getRandom(combine, check, n, k, chosen);
		}
		return combine;
    }
	
	

	public void getRandomSub(ArrayList<ArrayList<Integer>> combine,HashSet<HashSet<Integer>> check,int n,int k,HashSet<Integer> chosen){
        if(chosen.size() == k){
            if(!check.contains(chosen)){
            	 
                check.add(chosen);
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                for(Integer t : chosen){
                    tmp.add(t);
                }
                combine.add(tmp);
               
            }
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(chosen.contains(i)){
            	chosen.remove(i);
            	HashSet<Integer> chosen1 = new HashSet<Integer>();
        		for(Integer integer : chosen){
           		 chosen1.add(integer);
           	 	}
            	getRandomSub(combine,check,n,k,chosen1);
            	chosen.add(i);
            }
        }
    }
    
    public void getRandom(ArrayList<ArrayList<Integer>> combine,HashSet<HashSet<Integer>> check,int n,int k,HashSet<Integer> chosen){
    
    	if(chosen.size() == k){
            if(!check.contains(chosen)){
            	
                check.add(chosen);
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                for(Integer t : chosen){
                    tmp.add(t);
                }
                combine.add(tmp);
                return;
            } 
        } else {	
			 for(int i = 1; i <= n; i++){
				 if(!chosen.contains(i)){
            		chosen.add(i);
            		HashSet<Integer> chosen1 = new HashSet<Integer>();
            		for(Integer integer : chosen){
               		 chosen1.add(integer);
               	 	}
            		getRandom(combine,check,n,k,chosen1);
            		chosen.remove(i);
            	}
			 }
			
		}
    }
    
    int gcd(int a, int b){
    	return b==0 ? a : gcd(b, a%b);
    }
    public static void main (String[] args) {
    	Combine a = new Combine();
		 ArrayList<ArrayList<Integer>> combine = a.combine(5, 3);
		for(ArrayList<Integer> tmpArrayList : combine){
			System.out.println();
			for (Integer tInteger : tmpArrayList) {
				System.out.print(tInteger+",");
			}
		}
		
		HashSet<HashSet<Integer>> check = new HashSet<HashSet<Integer>>();
		for(int i = 1; i < 5; i++){
			HashSet<Integer> chosen = new HashSet<Integer>();
			chosen.add(1);
			chosen.add(i);
			check.add(chosen);
		}
		
		HashSet<Integer> chosen2 = new HashSet<Integer>();
		chosen2.add(2);
		chosen2.add(3);
		System.out.print(check.contains(chosen2));
		System.out.print(15%6 + " " + 6%15);
    }
}
