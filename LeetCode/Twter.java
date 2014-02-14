package LeetCode;

public class Twter {
	public static int equalityArray(int[][] A){
		int[] rowSum = new int[A.length];
		int[] colSum = new int[A[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				rowSum[i] += A[i][j];
			}
			System.out.println("r" + i+" = "+ rowSum[i]);
		}
		
		for(int j = 0; j < A[0].length; j++){
			for(int i = 0; i < A.length; i++){
				colSum[j] += A[i][j];
			}
			System.out.println("l" + j+" = "+ colSum[j]);
		}
		int n = 0;
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				if(rowEqua(rowSum,i,A)&&(colEqua(colSum, j, A))){
					n++;
				}
			}
		}
		return n;
	}
	
	public static boolean rowEqua(int[] rowSum,int r,int[][] A) {
		int up = 0;
		for(int i = 0;i < r; i++){
			up += rowSum[i];
		}
		int down = 0;
		for(int i = A.length -1;i > r; i--){
			down += rowSum[i];
		}
		System.out.println("r"+r+" up:" + up + " down" +down);
		if(down == up){
			return true;
		} else{
			return false;
		}
	}
	
	public static boolean colEqua(int[] colSum,int l,int[][] A) {
		int left =0;
		for(int j = 0; j < l;j++ ){
			left += colSum[j];
		}
		
		int right = 0;
		for(int j = A[0].length - 1; j > l;j--){
			right += colSum[j];
		}
		
		System.out.println("l"+l+" left:" + left + " right" +right);
		if(left == right){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
        int[][] A={{2,7,5},{3,1,1},{2,1,-7},{0,2,1},{1,6,8}};
        System.out.print(equalityArray(A));
	}
}
