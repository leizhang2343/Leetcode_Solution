package LeetCode;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null){
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(!isLetter(s.charAt(start))){
                start++;
                if(start >= end) return true;
            }
            while(!isLetter(s.charAt(end))){
                end--;
                if(start >= end) return true;
            }
            String left = s.charAt(start)+"";
            String right = s.charAt(end)+"";
            
            if(0!=left.compareToIgnoreCase(right)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    boolean isLetter(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
            return true;
        }
        return false;
    }
    
    public static void  main(String[] args) {
    	IsPalindrome test = new IsPalindrome();
    	System.out.println(test.isPalindrome(".2bc12b,"));
	}
}
