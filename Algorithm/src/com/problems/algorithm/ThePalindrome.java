package com.problems.algorithm;

public class ThePalindrome {
	
	public static int find(String s) {
		int ans = 0;
		
		int left = 0, right = s.length() - 1;
		while(left < right) {
			if(s.charAt(left) == (s.charAt(right))) {
				right --;
			} else {
				ans = left + 1;
				right = s.length() - 1;
			}
			left ++;
		}
		
		return s.length() + ans;
	}

	public static void main(String[] args) {
		System.out.println(find("abab"));
		System.out.println(find("abacaba"));
		System.out.println(find("qwerty"));
		System.out.println(find("abdfhdyrbdbsdfghjkllkjhgfds"));
		System.out.println(find("c"));

	}

}
