package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import LeetCode.CeckLoop.ListNode;

public class ReorderList {
	public static void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null){
            return;
        }
        Stack<ListNode> tmpStack = new Stack<ListNode>();
        Queue<ListNode> tmpQueue = new LinkedList<ListNode>();
        ListNode node = head;
        int list_size = 0;
        while(node != null){
            tmpStack.push(node);
            tmpQueue.add(node);
            list_size++;
            node = node.next;
        }
        if(list_size <= 2){
            return;
        }
        //begine to go
        node = tmpQueue.poll();
        boolean back = true;
        while(list_size > 0){
            if(back){
                node.next = tmpStack.pop();
            }else {
                node.next = tmpQueue.poll();
            }
            back = !back;
            System.out.print(node.value+"->");
            node = node.next;
            list_size--;
        }
    }
	
	public static void reverse(ListNode root){
		if(root == null) return;
		ListNode current = null;
		ListNode pre = null;
		ListNode next = null;
		current = root;
		while (current != null) {
			
			//取出当前节点的下一个节点
            next=current.next;
            //给当前节点赋值
            current.next=pre;
            //记录当前节点
            pre=current;
            //移动当下一个节点
             current=next;
			
		}
		
		while(pre!=null){
            System.out.println(pre.value+",");
            pre=pre.next;
        }
		
	}
	public static ListNode revers(ListNode root){
		if(root == null||root.next == null){
			return root;
		}
		ListNode next = root.next;
		ListNode head = revers(root.next);
		root.next = null;
		next.next = root;
		return head;
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode node = head;
		for(int i = 2; i < 101; i++){
			node.next = new ListNode(i);
			node = node.next;
		}
		System.out.println("1234567890123456789012345678901234567890"+ "\n"+ Integer.toBinaryString(-4));
//		reorderList(head);
		
		reverse(revers(head));
		System.out.println(null == null);
	}
}
