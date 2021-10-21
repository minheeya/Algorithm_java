package com.problems.algorithm;
import java.util.*;

public class InterestingParty {
	
	public static int bestInvitation(String[] first, String[] second) {
		
		HashMap<String, Integer> dic = new HashMap<>();
		
		//dic의 값을 0으로 초기화  
		for(int i = 0; i < first.length; i++) {
			dic.put(first[i], 0);
			dic.put(second[i], 0);
		}
		
		for(int i = 0; i < first.length; i++) {
			dic.put(first[i], dic.get(first[i]) + 1);
			dic.put(second[i], dic.get(second[i]) + 1);
		}
		
		int ans = 0;
		for(String key : dic.keySet()) {
			ans = Math.max(ans, dic.get(key));
		}
		
		return ans;
	}

	public static void main(String[] args) {
		String[] first = {"snakes", "programming", "cobra", "monty"};
		String[] second = {"python", "python", "anaconda", "python"};
		System.out.println(bestInvitation(first, second));
	}

}
