package leetcode;

public class T322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins)
                if(i >= coin)
                    min = Math.min(min, dp[i - coin] == -1 ? Integer.MAX_VALUE : dp[i - coin] + 1);
            dp[i] = min == Integer.MAX_VALUE ? - 1 : min;
        }
        
        return dp[amount];
    }
}
