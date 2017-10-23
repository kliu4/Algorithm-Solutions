package leetcode;

public class T712MinimumASCIIDelete {
	public int minimumDeleteSum(String word1, String word2) {
		int dp[][] = new int[word1.length()+1][word2.length()+1];
	    for(int i = 0; i <= word1.length(); i++) {
	        for(int j = 0; j <= word2.length(); j++) {
	            if(i == 0 || j == 0) dp[i][j] = 0;
	            else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + word1.charAt(i-1)
	                    : Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    int val =  dp[word1.length()][word2.length()];
	    int sum = 0; 
	    for(char c:word1.toCharArray())
	    		sum += c;
	    for(char c:word2.toCharArray())
	    		sum += c;
	    return sum - val - val;
    }
	
	public static void main(String[] args) {
		System.out.println(new T712MinimumASCIIDelete().minimumDeleteSum("delete", "leet"));
	}

}
