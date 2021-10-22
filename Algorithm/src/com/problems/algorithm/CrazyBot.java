package com.problems.algorithm;

public class CrazyBot {
	
	static boolean[][] grid = new boolean[100][100];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static double[] prob = new double[4];
	
	public static double getProbability(int n, int east, int west, int south, int north) {
		prob[0] = east / 100.0;  //동  
		prob[1] = west / 100.0;  //서  
		prob[2] = south / 100.0; //남 
		prob[3] = north / 100.0; //북 
		
		return dfs(50, 50, n);  //중간에서 출발 
	}
	
	public static double dfs(int x, int y, int n) {
		if(grid[x][y]) return 0; //이미 방문한 자리를 다시 방문하면 실패이므로 0반환 
		if(n == 0) return 1;  //더 이상 이동X 
		
		grid[x][y] = true;  //방문표시  
		double allProb = 0.0;
		for(int i = 0; i < 4; i++) {   //동서남북 이동 
			allProb += dfs(x + dx[i], y + dy[i], n - 1)*prob[i];
		}
		grid[x][y] = false;
		return allProb;
	}

	public static void main(String[] args) {
		System.out.println(getProbability(1, 25, 25, 25, 25));  //1.0
		System.out.println(getProbability(2, 25, 25, 25, 25));  //0.75
		System.out.println(getProbability(7, 50, 0, 0, 50));    //1.0
		System.out.println(getProbability(14, 50, 50, 0, 0));   
		System.out.println(getProbability(14, 25, 25, 25, 25));

	}

}
