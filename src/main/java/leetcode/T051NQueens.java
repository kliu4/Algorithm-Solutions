package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T051NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		int[][] matrix = new int[n][n];
		helper(result, 0, n, matrix, 0);
		return result;
	}

	private List<String> convert(int[][] matrix, int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String line = "";
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0)
					line += ".";
				else
					line += "Q";
			}
			list.add(line);
		}
		return list;
	}

	private void helper(List<List<String>> result, int queens, int n, int[][] matrix, int start) {
		if (queens == n) {
			result.add(convert(matrix, n));
			return;
		}

		for (int i = start; i < n; i++) {
			if (queens < i)
				break;
			for (int j = 0; j < n; j++) {
				if (!isGood(n, i, j, matrix))
					continue;
				queens++;
				matrix[i][j] = 1;
				helper(result, queens, n, matrix, i);
				queens--;
				matrix[i][j] = 0;
			}
		}
	}

	private boolean isGood(int n, int i, int j, int[][] matrix) {
		for (int m = 0; m < n; m++) {
			if (matrix[i][m] == 1)
				return false;

			if (matrix[m][j] == 1)
				return false;
		}

		for (int m = 0; m < n; m++) {
			if (i + m < n && j + m < n)
				if (matrix[i + m][j + m] == 1)
					return false;
			if (i - m >= 0 && j - m >= 0)
				if (matrix[i - m][j - m] == 1)
					return false;
			if (i - m >= 0 && j + m < n)
				if (matrix[i - m][j + m] == 1)
					return false;
			if (i + m < n && j - m >= 0)
				if (matrix[i + m][j - m] == 1)
					return false;
		}

		return true;
	}

	public static void main(String[] args) {
		new T051NQueens().solveNQueens(4);
	}
}
