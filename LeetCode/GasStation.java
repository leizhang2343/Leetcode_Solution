package LeetCode;

public class GasStation {
	    public static int canCompleteCircuit(int[] gas, int[] cost) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	         int all = 0;
	         int index = 0;
	         int firstNotNegative = 0;
	         for(int i = 0; i < gas.length;i++){
	             all += gas[i]-cost[i];
	             firstNotNegative += gas[i] - cost[i];
	             if(firstNotNegative < 0){
	                 index = i;
	                 firstNotNegative = 0; 
	             }
	               
	         }
	         System.out.println("all"+all);
	         if(all < 0){
	             return -1;
	         }
	         return index+1;
	        
	    }
	    public static void main(String[] args) {
	    	int[] gas = {1,2};
	    	int[] cost = {2,1};
	    	System.out.println("result:"+canCompleteCircuit(gas,cost));
			
		}
}
