package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T723CandyCrush {
	public int[][] candyCrush(int[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return board;

		int r = board.length;
		int c = board[0].length;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++) {
				if ((i - 2 >= 0 && board[i - 2][j] == board[i - 1][j] && board[i - 1][j] == board[i][j])
						|| (i + 2 < r && board[i + 2][j] == board[i + 1][j] && board[i + 1][j] == board[i][j])
						|| (j - 2 >= 0 && board[i][j - 2] == board[i][j - 1] && board[i][j - 1] == board[i][j])
						|| (j + 2 < c && board[i][j + 2] == board[i][j + 1] && board[i][j + 1] == board[i][j])
						|| (i - 1 >= 0 && i + 1 < r && board[i - 1][j] == board[i][j] && board[i][j] == board[i + 1][j])
						|| (j - 1 >= 0 && j + 1 < c && board[i][j - 1] == board[i][j]
								&& board[i][j] == board[i][j + 1]))
					list.add(new int[] { i, j });
			}
		if (list.isEmpty())
			return board;

		for (int[] point : list)
			board[point[0]][point[1]] = 0;

		for (int j = 0; j < c; j++) {
			for (int aa = r - 1, bb = r - 1; aa >= 0; aa--) {
				if (board[aa][j] == 0) {
					aa--;
					continue;
				} else {
					board[bb][j] = board[aa][j];
				}
			}
		}

		return candyCrush(board);
	}
}
