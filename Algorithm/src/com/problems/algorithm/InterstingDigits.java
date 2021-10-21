package com.problems.algorithm;

import java.util.*;

public class InterstingDigits {
	
	public static int[] digits(int base) {
		Vector<Integer> v = new Vector<>();
		for(int num = 2; num < base; num ++) {
			if((base - 1) % num == 0) v.add(num);
		}
		
		int[] ans = new int[v.size()];
		for(int i = 0; i < v.size(); i ++) ans[i] = v.get(i);
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(digits(10)));  //[3, 9]
		System.out.println(Arrays.toString(digits(8)));   //[7]
		System.out.println(Arrays.toString(digits(5)));   //[2, 4]

	}

}
