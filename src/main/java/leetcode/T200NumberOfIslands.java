package leetcode;

public class T200NumberOfIslands {
	public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int sum = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1'){
                    sum++;
                    getIslands(grid, i, j);
                }
        
        return sum;
    }
    
    private void getIslands(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            getIslands(grid, i - 1, j);
            getIslands(grid, i + 1, j);
            getIslands(grid, i, j - 1);
            getIslands(grid, i, j + 1);
        }
    }
}
