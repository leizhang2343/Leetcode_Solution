package LeetCode;

public class Candy {
	 public static int candy(int[] ratings) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int length = ratings.length;
	        if(length < 2){
	        	return 1;
	        }
	        int[] all = new int[length];
	        minCandy(0,ratings,1,all);
	        for(int i = 1; i < length;i++){
	            if(all[i]!=0){
	                continue;
	            } else {
	            	if(ratings[i] > ratings[i-1]){
	            		all[i] = minCandy(i,ratings,all[i-1]+1,all);
	            	}else {
	            		all[i] = minCandy(i,ratings,1,all);
	            	}
	                
	            }
	        }
	        int total=0;
	        for(int c : all){
	            total += c;
	        }
	        return total;
	    }
	    
	    public static int minCandy(int index,int[] ratings,int min,int[] all){
	    	if(index == 0){
	    		if(ratings[index] <= ratings[index + 1]){
	    			all[index] = 1;
		    		return 1;
	    		}else {
	    			all[index] = minCandy(index+1,ratings,min,all)+1;
		            return all[index];
	    		}
	    		
	        } else if((index == ratings.length -1)||(ratings[index] <= ratings[index + 1])){
	        	if(ratings[index] < ratings[index - 1]){
		            all[index] = 1;
		            return 1;
	        	} else {
	        		all[index] = min;
		            return min;
	        	}
	        } else{
	        	if(ratings[index] <= ratings[index - 1]){
	        		all[index] = minCandy(index+1,ratings,min,all)+1;
		            return all[index];
	        	} else{
	        		all[index] = Math.max(minCandy(index+1,ratings,min,all)+1,min);
		            return all[index];
	        	}
	            
	        }
	    }
	    
	    public static void main(String[] args){
	    	int[] rating = {5,1,1,1,10,2,1,1,1,3};
	    	System.out.println(candy(rating));
	    }
}
