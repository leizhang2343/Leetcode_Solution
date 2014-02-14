package LeetCode;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {
	public static int sumNumbers(TreeNode root) {
		if(root == null){
			return 0;
		}
		ArrayList<Integer> sum = new ArrayList<Integer>();
		recursiveGetSum(root, "", sum);
		int all = 0;
		for(Integer n:sum){
			
			all += n;
		}
		
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return all;
    }
    
    public static void recursiveGetSum(TreeNode root,String perent,ArrayList<Integer> sum){
        perent = perent+root.val;
        if(root.left==null && root.right == null ){
        	Integer tmpInt = Integer.parseInt(perent);
            sum.add(tmpInt);
        }
        if(root.left != null ){
            recursiveGetSum(root.left,perent,sum);
        }
        if(root.right != null ){
            recursiveGetSum(root.right,perent,sum);
        }
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		a.left = new TreeNode(3);
		a.left.left = new TreeNode(1);
		a.left.right = new TreeNode(4);
		a.right = new TreeNode(7);
		a.right.right = new TreeNode(8);
		a.right.left = new TreeNode(6);
		System.out.println(sumNumbers(a));
	}
}
