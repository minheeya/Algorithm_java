package com.problems.algorithm;
import java.util.*;


public class FriendScore {
	
	public static int highestScore(String[] friends) {
		int ans = 0;
		
		for(int i = 0; i < friends.length; i++) {
			int cnt = 0;
			for(int j = 0; j < friends.length; j++) {
				if(i == j) continue;
				
				if(friends[i].charAt(j) == 'Y') {
					cnt++;
				} else {
					for(int k = 0; k < friends.length; k++) { 
						// i와 j가 공통친구 k를 한명이라도 가지면 i와j는 친구  
						if(friends[j].charAt(k) == 'Y' && friends[i].charAt(k) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] friends1 = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
		String[] friends2 = {"NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", 
				"NNYNNNNNNN", "YYYNNNNNNY", "NNYNNNNNYN", "NYNNNNNYNN", 
				"NYNNNNYNNN", "NNNNNYNNNN", "NNNNYNNNNN"};
		String[] friends3 = {"NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNYNNNNNNN",
				"NNNNNNNYNNNNNNY", "NNNNNNNNNNNNNNY", "NNNNNNNNYNNNNNN",
				"NNNNNNNNNNNNNNN", "NNYYNNNNNNNNNNN", "NNNNNYNNNNNYNNN",
				"NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNNYNNNNNN",
				"NNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNN", "YNNYYNNNNYNNNNN"};
		
	    System.out.println(highestScore(friends1));    //4
	    System.out.println(highestScore(friends2));    //8
	    System.out.println(highestScore(friends3));    //6
	}
}
