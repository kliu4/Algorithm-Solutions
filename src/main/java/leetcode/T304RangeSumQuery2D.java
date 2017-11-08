package leetcode;

public class T304RangeSumQuery2D {
	private int[][] sums;

	public T304RangeSumQuery2D(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < sums.length; i++)
            for(int j = 1; j < sums[0].length; j++)
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
    }

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row2++;
		col2++;
		return sums[row2][col2] + sums[row1][col1] - sums[row1][col2] - sums[row2][col1];
	}
}
