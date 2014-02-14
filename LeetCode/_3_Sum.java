package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class _3_Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<3)
            return result;
        Arrays.sort(num);
        for(int i=0;i<=num.length-3;i++){
            int start=i+1,end=num.length-1;
            while(start<end){
                if((num[start]+num[end])==-num[i]){
                    ArrayList<Integer> newElement=new ArrayList<Integer>();
                    newElement.add(num[i]);
                    newElement.add(num[start++]);
                    newElement.add(num[end--]);
                    result.add(newElement);
                }
                else if((num[start]+num[end])>-num[i])
                    end--;
                else
                    start++;
            }
        }
        return result;
    }
	/*
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(num==null||num.length<3)
			return result;
		for(int i=0;i<num.length;i++){
			int min=i;
			for(int j=i+1;j<num.length;j++){
				if(num[min]>num[j])
					min=j;
			}
			int temp=num[i];
			num[i]=num[min];
			num[min]=temp;
		}
		return threeSumRecursive(num,0,0,3);
    }
	ArrayList<ArrayList<Integer>> threeSumRecursive(int[] num,int start,int target,int remains){
		if(start==num.length)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(remains==1){
			int begin=start;
			int end=num.length-1;
			boolean found=false;
			while(!found&&begin!=end){
				if(target==num[(begin+end)/2])
					found=true;
				else if(target<num[(begin+end)/2])
					end=(begin+end)/2;    //56 57 turn to 56 55 if end=(begin+end)/2-1;
				else
					begin=(begin+end)/2+1;
			}
			if(!found&&target!=num[(begin+end)/2])
				return result;
			else{
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(target);
				result.add(temp);
				return result;
			}
		}
		for(ArrayList<Integer> temp:threeSumRecursive(num,start+1,target-num[start],remains-1)){
			ArrayList<Integer> add=new ArrayList<Integer>();
			add.add(num[start]);
			add.addAll(temp);
			result.add(add);
		}
		for(int i=start+1;i<num.length;i++){
			if(num[i]>0&&num[i]>target)
				break;
			if(num[i]!=num[i-1]){
				for(ArrayList<Integer> temp:threeSumRecursive(num,i+1,target-num[i],remains-1)){
					ArrayList<Integer> add=new ArrayList<Integer>();
					add.add(num[i]);
					add.addAll(temp);
					result.add(add);
				}
			}
		}
		return result;
	}*/
	public static void main(String[] args){
		_3_Sum t=new _3_Sum();
		System.out.println(t.threeSum(new int[]{1,0,-1,0,-2,2,0}));
		System.out.println(t.threeSum(new int[]{-499,-449,-410,-386,-384,-357,-332,-321,-304,-290,-248,-243,-240,-220,-216,-207,-199,-197,-183,-172,-169,-164,-149,-143,-111,-108,-84,-57,-51,-49,-48,-7,-4,10,17,66,111,149,170,174,176,188,198,205,216,257,311,313,327,330,334,335,358,375,375,380,392,422,442,461,466,487}));
    }
}

