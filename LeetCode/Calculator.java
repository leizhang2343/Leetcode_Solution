package LeetCode;

import java.util.*;

public class Calculator {
    private static double cal(char op, double p1, double p2) {
        switch(op) { 
            case '+': return p1 + p2; 
            case '-': return p1 - p2; 
            case '*': return p1 * p2; 
            case '/': return p1 / p2;
            default:  throw new ArithmeticException(op + " not defined");
        }
    }
    
    public static double eval(String expr) {
        LinkedList<Double> stack = new LinkedList<>();
        for(char c : expr.toCharArray()) {
            if("+-*/".indexOf(c) != -1) {
                double p2 = stack.removeLast();
                double p1 = stack.removeLast();
                stack.add(cal(c, p1, p2));
            } else { stack.add(Double.parseDouble(String.valueOf(c))); } 
        }
        return stack.getLast();
    }        
    
    public static void main(String[] args) {
        System.out.println(eval("22222131242421**+"));
    }
}