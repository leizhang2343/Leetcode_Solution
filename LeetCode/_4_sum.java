package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class _4_sum {
	 static class Resutl4{
		int a,b,c,d;
		Resutl4(int a,int b,int c,int d){
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Resutl4 resutl4 = (Resutl4) obj;
			int n = 0;
			if(a == resutl4.a|| a == resutl4.b || a == resutl4.c ){
				n++;
			}
			if(b == resutl4.a|| b == resutl4.b || b == resutl4.c ){
				n++;
			}
			if(c == resutl4.a|| c == resutl4.b || c == resutl4.c ){
				n++;
			}
			if(n == 3){
				return true;
			} else {
				return false;
			}
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			
			return a+b+c+d;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return a+","+b+","+c+","+d;
		}
		
	}
	
	public void getSumEachPair(HashMap<Integer, ArrayList<int[]>> eachSum,int[] allNum,HashMap<Integer, ArrayList<int[]>> eachResiduum){
		int a,b;
		for(int i = 0; i < allNum.length;i++){
			a = allNum[i];
			for(int j = 0; j < allNum.length;j++){
				if(i != j) {
					b = allNum[j];
					insertHashmap(eachSum, a+b, a, b);
					insertHashmap(eachResiduum, a - b, a, b);
					insertHashmap(eachResiduum, b - a, b, a);
				}
			}
		}
	}
	
	public void insertHashmap(HashMap<Integer, ArrayList<int[]>> eachSum,int sum,int a,int b){
		if(eachSum.containsKey(sum)){
			for(int i = 0; i < eachSum.get(sum).size();i++){
//			for(int[] eachPair : eachSum.get(sum)){
				int[] eachPair = eachSum.get(sum).get(i);
				if((eachPair[0] == a && eachPair[1] == b)|| (eachPair[0] == b && eachPair[1] == a)){
					return;
				} else {
					int[] tmpPair = {a,b};
					eachSum.get(sum).add(tmpPair);
				}
			}
		} else {
			ArrayList<int[]> eachTmp = new ArrayList<>();
			int[] tmpPair = {a,b};
			eachTmp.add(tmpPair);
			eachSum.put(sum, eachTmp);
		}
	}
	
	public HashSet<Resutl4> findResult(HashMap<Integer, ArrayList<int[]>> eachSum,HashMap<Integer, ArrayList<int[]>> eachResiduum){
		HashSet<Resutl4> allResult = new HashSet<>();
		Iterator i = eachSum.entrySet().iterator();
        while(i.hasNext()){
            Entry<Integer,ArrayList<int[]>> entry = (Entry) i.next();
            int sum = (Integer)entry.getKey();
           
            Iterator j = eachResiduum.entrySet().iterator();
            while (j.hasNext()) {
            	
            	 Entry<Integer,ArrayList<int[]>> entryJ = (Entry) j.next();
            	 int residuum = (Integer)entryJ.getKey();
				if(sum == residuum){
					for(int[] tmpSumPair : eachSum.get(sum)){
						for(int[] tmpResPair : eachResiduum.get(residuum)){
							Resutl4 tmpResut = new Resutl4(tmpSumPair[0],tmpSumPair[1],tmpResPair[1],tmpResPair[0]); 
							allResult.add(tmpResut);
						}
					}
				}
			}
        }
		return allResult;
	}
	
	public static void main(String[] args){
		int[] input = {1,1,1,1,3,4,5,8,2,7,3,4};
		HashMap<Integer, ArrayList<int[]>> eachSum = new HashMap<>();
		HashMap<Integer, ArrayList<int[]>> eachResiduum = new HashMap<>();
		_4_sum test_4_sum  = new _4_sum();
		test_4_sum.getSumEachPair(eachSum, input, eachResiduum);
		HashSet<Resutl4> allResult = test_4_sum.findResult(eachSum, eachResiduum);
		for(Resutl4 tmp : allResult){
			System.out.println(tmp);
		}
	}
}
