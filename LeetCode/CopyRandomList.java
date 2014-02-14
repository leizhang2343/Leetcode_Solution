package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyRandomList {
    public static RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null){
            return null;
        }
        ArrayList<RandomListNode> allOriginal = new ArrayList<RandomListNode>();
        ArrayList<RandomListNode> allNew = new ArrayList<RandomListNode>();
        RandomListNode node = head;
        RandomListNode newHead = null;
        int n = 0;
        HashMap<RandomListNode,Integer> oldNodes = new HashMap<RandomListNode,Integer>();
        while(node != null){
            allOriginal.add(node);
            newHead = new RandomListNode(node.label);
            allNew.add(newHead);
            oldNodes.put(node,n);
            node = node.next;
            n++;
        }
        for(int i = 0; i < allNew.size();i++){
            if(i == allNew.size() - 1){
                allNew.get(i).next = null;
            } else {
                 allNew.get(i).next = allNew.get(i+1);
            }
           RandomListNode random = allOriginal.get(i).random;
           if(!(random == null)){
               int randomNum = oldNodes.get(random);
               allNew.get(i).random = allNew.get(randomNum);
           } else {
               allNew.get(i).random = null;
           }
           
        }
        return allNew.get(0);
    }
    public static void main(String[] args) {
    	RandomListNode a = new RandomListNode(-1);
    	a.next = null;
    	a.random = null;
    	copyRandomList(a);
	}
}