package LeetCode;

import java.util.ArrayList;

public class CeckLoop {
	 public static class ListNode {

	     public ListNode(int i) {
			// TODO Auto-generated constructor stub
	    	 value = i;
		}

		public int value;

	     public ListNode next;
	  }
	 
	  public static boolean hasLoops( ListNode myList ) {
		  ListNode slow = myList;
		  ListNode fast = myList;
		  /*Find the meeting point*/
		  while(fast != null && fast.next != null){
			  slow = slow.next;
			  fast = fast.next.next;
			  if(slow == fast){ //collision
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public static void main(String[] args) {
		  ArrayList<ListNode> allArrayList = new ArrayList<>();
		  for(int i = 0; i <11;i++){
			  ListNode tmp = new ListNode();
			  allArrayList.add(tmp);
		  }
		  for(int i = 0; i <10;i++){
			  allArrayList.get(i).next = allArrayList.get(i+1);
		  }
		  allArrayList.get(5).next = allArrayList.get(4);
		  System.out.println(hasLoops(allArrayList.get(0)));
	}

}
