package LeetCode;

import java.util.ArrayList;

public class TextJustification {
    public static ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(words.length < 1){
            return null;
        }
        ArrayList<String> allStrings = new ArrayList<String>();
        int begin = 0;
        while(begin < words.length){
            begin = singleRow(words,L,begin,allStrings);
            if(begin == -1){
                return null;
            }
        }
        return allStrings;
    }
    
    public static int singleRow(String[] words,int L,int begin,ArrayList<String> allStrings){
    	
        if(words.length == begin + 1){
        	System.out.println(words.length+" ->" + begin);
            String all = words[begin];
            int allBlank = L - words[begin].length();
            while(allBlank > 0){
                all = all + " ";
                allBlank--;
            }
            allStrings.add(all);
            return begin+2;
        }
        int sum = 0;
        String all = "";
        int until = 0;
        int blankAdded = 0;
        for(int i = begin; i < words.length;i++){
            if(words[i].length() > L){
                return -1;
            }
            all = all + words[i] + " ";
            sum += words[i].length()+1;
            blankAdded++;
            if(sum-1 > L){
                sum = sum - words[i].length()-2;
                until = i;
                blankAdded = blankAdded -2;
                break;
            } else if(sum - 1 == L){
                until = i;
               
                allStrings.add(all.substring(0,sum -1));
                return until;
            }
        }
        int moreBlank = L - sum;
        
        int addMoreEach = moreBlank/blankAdded;
        

        System.out.println("more:"+moreBlank+"each:"+ addMoreEach);
        String addMoreEachString = " ";
        for(int i = 0; i < addMoreEach;i++){
            addMoreEachString = addMoreEachString +" ";
        }
        int addMoreFirest = moreBlank%blankAdded;
        String allOf = "";
        for(int i = begin; i < until-1;i++){
            allOf = allOf+ words[i]+addMoreEachString;
            if(addMoreFirest > 0){
                allOf = allOf+" ";
                addMoreFirest--;
            }
        }
        allOf = allOf + words[until-1];
        System.out.println(until);
        allStrings.add(allOf);
        return until;
    }
    
    public static void main(String[] args){
    	String[] all = {"This", "is", "an", "example", "of", "text", "justification."};
    	ArrayList<String> allStrings =  fullJustify(all,16);
    	for(String s:allStrings){
    		System.out.println(s);
    	}
    }
}
