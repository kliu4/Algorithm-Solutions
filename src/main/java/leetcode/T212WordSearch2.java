package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T212WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board.length == 0 || board[0].length == 0)
            return result;
        
        int[][] visited = new int[board.length][board[0].length];
        
        Set<String> wordsSet = new HashSet<String>();
        
        for(String str: words){
            if(!wordsSet.add(str))
                continue;
            boolean isFound = false;
            for(int i = 0; i < board.length && !isFound; i++)
                for(int j = 0; j < board[0].length && !isFound; j++){
                    if(dfs(board, str.toCharArray(), i, j, 0, visited)){
                        result.add(str);
                        isFound = true;
                    }
                }
        }
        return result;
    }
    
    private boolean dfs(char[][] board, char[] chars, int i, int j, int index, int[][] visited){
        if(index == chars.length)
            return true;
        
        if(i < 0 || i >= board.length || j < 0  || j >= board[0].length || visited[i][j] == 1)
            return false;
        
        boolean b = false;
        if(board[i][j] == chars[index]){
            visited[i][j] = 1;
            b = dfs(board, chars, i + 1, j, index + 1, visited)
                || dfs(board, chars, i - 1, j, index + 1, visited)
                || dfs(board, chars, i, j + 1, index + 1, visited)
                || dfs(board, chars, i, j - 1, index + 1, visited);
            visited[i][j] = 0;
        }
        
        return b;
    }
}
