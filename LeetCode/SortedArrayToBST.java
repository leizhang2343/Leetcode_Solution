package LeetCode;


public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length <1){
            return null;
        }
        return buildTree(0,num.length-1,num);
    }
    
    public static TreeNode buildTree(int begin,int end,int[] num){
        if(begin == end){
            return null;
        }
        if(Math.abs(end - begin) ==1){
        	if(end > begin){
        		TreeNode root = new TreeNode(num[end]);
        		root.left = new TreeNode(num[begin]);
        		root.right = null;
        		return root;
        	} else {
        		TreeNode root = new TreeNode(num[begin]);
        		root.right = new TreeNode(num[end]);
        		root.left = null;
        		return root;
        	}
        }
        int index = (begin+end)/2;
        TreeNode root = new TreeNode(num[index]);
        root.left = buildTree(begin,index-1,num);
        root.right = buildTree(index+1,end,num);
         return root;
    }
    public static void main(String[] args) {
		int[] all = {1,2};
		TreeNode rooTreeNode = sortedArrayToBST(all);
	}
   
}
