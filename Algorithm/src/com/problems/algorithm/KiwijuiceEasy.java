package com.problems.algorithm;
import java.util.*;

public class KiwijuiceEasy {
	
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for(int i = 0; i < fromId.length; i++) {
			int f = fromId[i];
			int t = toId[i];
			
			int sum = bottles[f] + bottles[t];
			bottles[t] = Math.min(capacities[t], sum);
			bottles[f] = sum - bottles[t];
		}
		
		return bottles;
	}

	public static void main(String[] args) {
		//test case
		int[] capacities = {10, 10};
		int[] bottles = {5, 8};
		int[] fromId = {0};
		int[] toId = {1};
		
		System.out.println(Arrays.toString(thePouring(capacities, bottles, fromId, toId)));
		// [3, 10] 출력 
	}

}
