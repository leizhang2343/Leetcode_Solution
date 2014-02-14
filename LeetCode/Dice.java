package LeetCode;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Dice {
	int[] getRate(){
		int all = 0;
		int threeTows = 0;
		for(int d = 1; d <=6;d++){
			for(int d1 = 1; d1 <=6;d1++){
				for(int d2 = 1; d2 <=6;d2++){
					for(int d3 = 1; d3 <=6;d3++){
						for(int d4 = 1; d4 <=6;d4++){
							all ++;
							int tows = 0;
							if(d == 2) tows = tows+1;
							if(d1 == 2) tows = tows+1;
							if(d2 == 2) tows = tows+1;
							if(d3 == 2) tows = tows+1;
							if(d4 == 2) tows = tows+1;
							if(tows >= 3) threeTows ++;
						}
					}
				}
			}
		}
		
		return new int[] {all, threeTows};
	}
	
	public static void main(String[] args) {
		Dice testDice = new Dice();
		System.out.println(testDice.getRate()[1]);
		System.out.print(testDice.getRate()[0]);
	}
	
}
