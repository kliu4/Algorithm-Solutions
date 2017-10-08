package leetcode;

public class T695MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)
                    max = Math.max(max, getIslandArea(grid, i, j));
        
        return max;
    }
    
    private int getIslandArea(int[][] grid, int i, int j){
        int area = 0;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        return 1 + getIslandArea(grid, i - 1, j) + getIslandArea(grid, i, j - 1) 
            + getIslandArea(grid, i + 1, j) + getIslandArea(grid, i, j + 1);
    }

}
