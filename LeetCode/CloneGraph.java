package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

public class CloneGraph {
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null){
            return null;
        }
        HashMap<Integer,UndirectedGraphNode> oldNodes = new HashMap<Integer,UndirectedGraphNode>();
        HashMap<Integer,UndirectedGraphNode> newNodes = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> nodeDFS = new LinkedList<UndirectedGraphNode>();
        nodeDFS.add(node);
        oldNodes.put(node.label, node);
        while(!nodeDFS.isEmpty()){
        	UndirectedGraphNode tmpnode = nodeDFS.poll();
        	UndirectedGraphNode cloneNode = new UndirectedGraphNode(tmpnode.label);
        	newNodes.put(cloneNode.label, tmpnode);
        	for(UndirectedGraphNode neighbor : tmpnode.neighbors){
        		if(!oldNodes.containsKey(neighbor.label)){
        			nodeDFS.add(neighbor);
        			oldNodes.put(neighbor.label, neighbor);
        		}
        	}
        }
        Set set2 = newNodes.keySet();
        Iterator i = set2.iterator();
        boolean first = true;
        UndirectedGraphNode newFirstNode = null;
        while(i.hasNext()){
            Integer ix = (Integer)i.next();
            UndirectedGraphNode n  = newNodes.get(ix);
            if (first) {
            	newFirstNode = n;
            	first = false;
			}
            UndirectedGraphNode oldNode = oldNodes.get(n.label);
            int num = oldNode.neighbors.size();
            System.out.println(num);
            for(int ix1 = 0; ix1 < num;ix1++){
            	int tmpN = oldNode.neighbors.get(ix1).label;
            	n.neighbors.add(newNodes.get(tmpN));
            }
        }
        
        return newFirstNode;
    }
	
	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(new UndirectedGraphNode(3));
		node.neighbors.add(new UndirectedGraphNode(1));
		node.neighbors.add(new UndirectedGraphNode(4));
		node.neighbors.add(new UndirectedGraphNode(5));
		node.neighbors.add(new UndirectedGraphNode(67));
		node.neighbors.add(new UndirectedGraphNode(7));
		node.neighbors.add(new UndirectedGraphNode(8));
		node.neighbors.add(node);
		System.out.println(node.neighbors.size());
		System.out.println(cloneGraph(node).label);
	}
}
