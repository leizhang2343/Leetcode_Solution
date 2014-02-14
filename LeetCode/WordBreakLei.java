package LeetCode;

import java.util.ArrayList;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a 
 * space-separated sequence of one or more dictionary words.
 * For example, givens = "leetcode",dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreakLei {
	 public static boolean wordBreak(String s, Set<String> dict) {
		 return true;
	 }
	 
	 public ArrayList<String> getAllSegment(String S,ArrayList<ArrayList<String>> all){
		 
		 for(int i = S.length() - 1; i >=0; i--){
			 ArrayList<String> oneSegment = new ArrayList<String>();
			 String tmpL = S.substring(0, i);
			 oneSegment.add(tmpL);
			 String tmpR = S.substring(i, S.length() -1);
			 oneSegment.addAll(getAllSegment(tmpR, all));
			 all.add(oneSegment);
		 }
		 return oneSegment;
	 }
	 
	 public void getAllSegmentBit(String S,ArrayList<ArrayList<String>> all){
		 
	 }
	 
	 public boolean wordBreakRcusion() {
		 
		return false;
	}
}
