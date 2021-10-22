package com.problems.algorithm;
import java.util.*;

public class MazeMaker {
	
	public static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		int max = 0;
		int width = maze[0].length(), 
			height = maze.length;
		int[][] board = new int[height][width];
		
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				board[i][j] = -1;  //방문여부 표시 & 최단거리 기록
		board[startRow][startCol] = 0; //출발지점 
		
		Queue<Integer> qX = new LinkedList<>();
		Queue<Integer> qY = new LinkedList<>();
		qX.add(startRow);
		qY.add(startCol);
		
		while(!qX.isEmpty()) {
			int x = qX.poll(), y = qY.poll();
			
			for(int i = 0; i < moveRow.length; i++) {
				int nextX = x + moveRow[i], 
					nextY = y + moveCol[i];
				
				if((0 <= nextX && nextX < height) && (0 <= nextY && nextY < width) 
						&& board[nextX][nextY] == -1
						&& maze[nextX].charAt(nextY) == '.') {
					board[nextX][nextY] = board[x][y] + 1;
					qX.add(nextX);
					qY.add(nextY);
				}
			}
		}
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(maze[i].charAt(j) == '.' && board[i][j] == -1)  
					//출구를 놓 수 있는 곳에 방문하지 못할경우 해당 위치에 출구를 놓으면 미로에서 나오지 못하게 할 수 있음 
					return -1;
				max = Math.max(max, board[i][j]);
			}
		}
		
		
		return max;
	}

	public static void main(String[] args) {
		int startRow = 0;
		int startCol = 1;
		
		String[] maze1 = {"...", "...", "..."};
		int[] moveRow1 = {1, 0, -1, 0};
		int[] moveCol1 = {0, 1, 0, -1};
		
		String[] maze2 = {"X.X", "...", "XXX", "X.X"};
		int[] moveRow2 = {1, 0, -1, 0};
		int[] moveCol2 = {0, 1, 0, -1};
		
		int startRow3 = 5;
		int startCol3 = 0;
		String[] maze3 = {".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......."};
		int[] moveRow3 = {1, 0, -1, 0, -2, 1};
		int[] moveCol3 = {0, -1, 0, 1, 3, 0};
		
		System.out.println(longestPath(maze1, startRow, startCol, moveRow1, moveCol1)); //3
		System.out.println(longestPath(maze2, startRow, startCol, moveRow2, moveCol2)); //-1
		System.out.println(longestPath(maze3, startRow3, startCol3, moveRow3, moveCol3)); //7

	}

}
