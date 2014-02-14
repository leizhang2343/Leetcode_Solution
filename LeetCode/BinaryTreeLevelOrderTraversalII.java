package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return all;
        }
        Queue<TreeNode> BFSQueue = new LinkedList<TreeNode>();
        BFSQueue.add(root);
        BFSTraversal(BFSQueue,all);
        return all;
        
    }
    
    void BFSTraversal(Queue<TreeNode> BFSQueue,ArrayList<ArrayList<Integer>> all){
        ArrayList<Integer> tmpArray = new ArrayList<Integer>();
        Queue<TreeNode> newBFSQueue = new LinkedList<TreeNode>();
        while(!BFSQueue.isEmpty()){
            TreeNode tmpNode = BFSQueue.poll();
            tmpArray.add(tmpNode.val);
            if(tmpNode.left != null){
                newBFSQueue.add(tmpNode.left);
            }
            if(tmpNode.right != null){
                newBFSQueue.add(tmpNode.right);
            }
        }
        all.add(0,tmpArray);
        if(!newBFSQueue.isEmpty()){
            BFSTraversal(newBFSQueue,all);
        }
    } 
    
}
