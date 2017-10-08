package leetcode;

public class T37SodokuSolver {
	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isGood(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }

	private boolean isGood(char[][] board, int i, int j, char c) {
		for (int m = 0; m < board.length; m++) {
			if (board[i][m] == c)
				return false;
			if (board[m][j] == c)
				return false;
		}

		int row = (i / 3) * 3;
		int col = (j / 3) * 3;
		for (int m = row; m <= row + 2; m++)
			for (int n = col; n <= col + 2; n++)
				if (board[m][n] == c)
					return false;

		return true;
	}

	public static void main(String[] args) {
		String[] strs = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.",
				"........6", "...2759.." };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			board[i] = strs[i].toCharArray();
		}
		new T37SodokuSolver().solveSudoku(board);
	}
}
