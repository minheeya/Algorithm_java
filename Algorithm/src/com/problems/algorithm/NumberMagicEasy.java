package com.problems.algorithm;
import java.util.*;

public class NumberMagicEasy {
	
	public static int theNumber(String answer) {
		String[] card = {
				"YYYYYYYYNNNNNNNN",
				"YYYYNNNNYYYYNNNN",
				"YYNNYYNNYYNNYYNN",
				"YNYNYNYNYNYNYNYN"};
		
		for(int i = 0; i < 16; i++) {
			String temp = "";
			for(int j = 0; j < 4; j++) temp += card[j].charAt(i);
			if(temp.equals(answer)) return i + 1;
		}
		return 0;
		
	}

	public static void main(String[] args) {
		
		System.out.println(theNumber("YNYY")); //5
		System.out.println(theNumber("YNNN")); //8
		System.out.println(theNumber("NNNN")); //16
		System.out.println(theNumber("NYNY")); //11
	}

}
