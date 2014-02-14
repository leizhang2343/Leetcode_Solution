package LeetCode;

import javax.sound.midi.SysexMessage;

public class DoubleToString {
	public static void main(String[] args){
		
		String s = String.format("%f%9%9", -8.000001);
		System.out.println(String.format("%1$.10f", 12.1));
		System.out.print(s);
	}
}
