package leetcode;

public class T130SUrroundedRegions {
	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			findLives(board, i, 0, m, n);
			findLives(board, i, n - 1, m, n);
		}
		for (int i = 0; i < n; i++) {
			findLives(board, 0, i, m, n);
			findLives(board, m - 1, i, m, n);
		}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'L')
					board[i][j] = 'O';
			}
	}

	private void findLives(char[][] board, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;
		if (board[i][j] == 'X' || board[i][j] == 'L')
			return;

		board[i][j] = 'L';
		findLives(board, i - 1, j, m, n);
		findLives(board, i + 1, j, m, n);
		findLives(board, i, j - 1, m, n);
		findLives(board, i, j + 1, m, n);
	}
}
