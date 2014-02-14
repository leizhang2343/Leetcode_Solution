package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AverageScore {
	static class TestResult{
		   int studentId;
		   String testDate;
		   int testScore;
		   public TestResult(int id,String data,int s){
			   studentId = id;
			   testDate = data;
			   testScore = s;
			// TODO Auto-generated constructor stub
		}
		}

	public static Map<Integer, Double> getFinalScores(List<TestResult> resultList){
		HashMap<Integer, PriorityQueue<Double>> all = new HashMap<Integer, PriorityQueue<Double>>();
		Map<Integer, Double> resultMap  = new HashMap<Integer, Double>(); 
		for(TestResult tmpTestResult : resultList){
			if(!all.containsKey(tmpTestResult.studentId)){
				all.put(tmpTestResult.studentId, new PriorityQueue<Double>());
				all.get(tmpTestResult.studentId).add((double) tmpTestResult.testScore);
			} else {
				all.get(tmpTestResult.studentId).add((double) tmpTestResult.testScore);
			}
		}
		Set allSet = all.keySet();
		Iterator it = allSet.iterator();
		while(it.hasNext()){
			Integer id = (Integer) it.next();
			PriorityQueue<Double> tmpDoubles = all.get(id);
			double finalS = 0;
			if(tmpDoubles.size() >= 5){
				for (int i = 0; i < 5; i++) {
					finalS += tmpDoubles.poll();
				}
				
			} else {
				while(!tmpDoubles.isEmpty()){
					finalS += tmpDoubles.poll();
				}
			}
			resultMap.put(id, finalS/5);
		}
		
		   return resultMap;
		}
	
	public static void main(String[] args) {
		List<TestResult> resultList = new ArrayList<>();
		for(int i = 1; i<=100;i++){
			resultList.add(new TestResult(i/6, "fdss", i));
		}
		Map<Integer, Double> resultMap = getFinalScores(resultList);
		System.out.print(resultMap);

	}
}
