package LeetCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class Coins {
  static final int[] DENOMINATIONS = {2, 10, 5, 1};
  static int MEN[] = new int[10001];
  
  public static int getMinChangeNumber(int n){
	  if(n < 0){
		  return Integer.MAX_VALUE - 1;
	  } else if( n== 0){
		  return 0;
	  } else if(MEN[n] != 0){
		  return MEN[n];
	  } else {
		  MEN[n] = 1 + getMinChangeNumber(n - DENOMINATIONS[0]);
		  for(int i = 1; i < DENOMINATIONS.length;i++){
			  MEN[n] = Math.min(MEN[n], 1 + getMinChangeNumber(n - DENOMINATIONS[i]));
		  }
		  return MEN[n];
	  }
  }
  
  public static void change(int amount) {
    change(amount, new ArrayList<Integer>(), 0);
  }

  private static void change(int remaining, List<Integer> coins, int pos) {
    if (remaining == 0) {
      System.out.println(coins);
    } else {
      if (remaining >= DENOMINATIONS[pos]) {
        coins.add(DENOMINATIONS[pos]);
        change(remaining - DENOMINATIONS[pos], coins, pos);
        coins.remove(coins.size() - 1);
      }
      StringBuffer aBuffer  = "ssf".toCharArray();
      char[] a = {'s'};
      a.toString()
      if (pos + 1 < DENOMINATIONS.length) {
        change(remaining, coins, pos + 1);
      }
    }
  }
  
  public static void main(String[] args){
	  LinkedHashMap<Integer, Integer> test= new LinkedHashMap<>();
	  test.
	 System.out.print( getMinChangeNumber(13));
	 Random generator = new Random();
	 System.out.println(Integer.MAX_VALUE);
	 int i  = generator.nextInt(1000000000);
//	 Coins.change(45);
  }
}