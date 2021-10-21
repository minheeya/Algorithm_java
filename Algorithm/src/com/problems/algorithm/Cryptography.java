package com.problems.algorithm;
import java.util.*;

public class Cryptography {
	
	public static long encrypt(int[] numbers) {
		long mul = 1;
		Arrays.sort(numbers);
		numbers[0]++;
		for(int i = 0; i < numbers.length; i++) {
			mul *= numbers[i];
		}
		return mul;
		
	}
	
	public static void main(String[] args) {
		int[] numbers = {23, 5, 6, 25, 3, 8, 9, 10, 12};
		System.out.println(encrypt(numbers));
	}
}
