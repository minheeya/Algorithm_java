package com.problems.algorithm;
import java.util.Scanner;
import java.lang.Math;

public class InsertOperator {
	static int N;
	static int[] nums;
	static int[] ops = new int[4];
	static Integer max_value = Integer.MIN_VALUE, min_value = Integer.MAX_VALUE;
	
	public static void dfs(int depth, int result) {
		if(depth == N) {
			max_value = Math.max(max_value, result);
			min_value = Math.min(min_value, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(ops[i] != 0) {
				ops[i]--;
				switch (i) {
				
				case 0: dfs(depth + 1, result + nums[depth]); break;
				case 1: dfs(depth + 1, result - nums[depth]); break;
				case 2: dfs(depth + 1, result * nums[depth]); break;
				case 3: dfs(depth + 1, result / nums[depth]); break;
				
				}
				ops[i]++;   // 원상태로 복구
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N];
		for(int i = 0; i < N; i ++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 4 ; i ++) {
			ops[i] = sc.nextInt();
		}
		
		dfs(1, nums[0]);
		System.out.println(max_value);
		System.out.println(min_value);
		
	}

}
