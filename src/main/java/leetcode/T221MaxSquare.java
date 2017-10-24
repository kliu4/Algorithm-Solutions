package leetcode;

public class T221MaxSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++)
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] != '1')
                    continue;
                if(dp[i - 1][j - 1] == 0)
                    dp[i][j] = 1;
                else{
                    int size = dp[i - 1][j - 1];
                    int ii = 1;
                    for(; ii <= size; ii++){
                        if(matrix[i - 1 - ii][j - 1] != '1' || matrix[i - 1][j - 1 -ii] != '1'){
                            break;
                        }
                    }
                    dp[i][j] = ii;
                }
                max = Math.max(dp[i][j], max);
            }
        
        return max * max;
    }
}
