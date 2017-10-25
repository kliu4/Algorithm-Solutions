package leetcode;

import java.util.List;

public class T139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            String left = s.substring(0, i);
            for(String word:wordDict){
                if(left.endsWith(word) && dp[i - word.length()]){
                    dp[i] = true;
                    break;
                }
            }
        } 
		return dp[s.length()];
	}
}
