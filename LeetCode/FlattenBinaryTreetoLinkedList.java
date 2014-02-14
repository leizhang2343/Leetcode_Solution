package LeetCode;

public class FlattenBinaryTreetoLinkedList {
    
    public TreeNode insertleft (TreeNode root){
    	if(root == null){
    		return null;
    	}
        if(root.left == null) {
            if(root.right == null){
                return root;
            }
            return insertleft(root.right);
        } else {
            TreeNode tmp = root.right;
            root.right = root.left;
            TreeNode tmpLeft = insertleft(root.right);
            if(tmpLeft != null){
            	tmpLeft.right = tmp;
            }
        
            return insertleft(tmp);
        }
    }
    public static void main(String[] args){
    	FlattenBinaryTreetoLinkedList test = new FlattenBinaryTreetoLinkedList();
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(4);
//    	root.right = new TreeNode(4);
    	test.insertleft(root);
    }
}
