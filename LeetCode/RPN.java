package LeetCode;

import java.util.Stack;

public class RPN {
	
	public double getValueOfRPN(String input){
		Stack<Double> stack = new Stack<Double>();
		String[] allChar = input.split(" ");
        double tmpNum;
        double tmpDouble1;
		double tmpDouble2;
        char tmpChar;
        for(int i = 0; i < allChar.length; i++){
			tmpChar = allChar[i].charAt(0);
			if(tmpChar - '0' >= 0 && tmpChar - '9' <= 0){
				tmpNum = Double.parseDouble(allChar[i]);
				System.out.println(tmpChar+" "+tmpNum);
				stack.push(tmpNum);
			}else if(tmpChar == '+'|| tmpChar == '-'|| tmpChar == '*'|| tmpChar=='/'){
				switch (tmpChar) {
				case '+':
					tmpDouble1 = stack.pop();
					tmpDouble2 = stack.pop();
					stack.push(tmpDouble2 + tmpDouble1);
					break;
				case '-':
					 tmpDouble1 = stack.pop();
					 tmpDouble2 = stack.pop();
					stack.push(tmpDouble2 - tmpDouble1);
					break;
				case '*':
					 tmpDouble1 = stack.pop();
					 tmpDouble2 = stack.pop();
					stack.push(tmpDouble2 * tmpDouble1);
					break;
				case '/':
					 tmpDouble1 = stack.pop();
					 tmpDouble2 = stack.pop();
					stack.push(tmpDouble2 / tmpDouble1);
					break;
				}
			}
        	
        }
        
        if(stack.size() == 1){
    		return stack.pop();
    	} else {
			return Integer.MIN_VALUE;
		}
	}
	
    public static void main(String[] args) {
       

//      String x = JOptionPane.showInputDialog("Tokens");
        String x = "4 13 5 / +";
        RPN test = new RPN();
        System.out.print(test.getValueOfRPN(x));
       
    }

}
