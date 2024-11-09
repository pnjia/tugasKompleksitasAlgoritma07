import java.util.Arrays;

public class CoinChange {

    
    public static int minCoins(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int amount = 27; 
        int[] coins = {2, 3, 5, 10, 15}; 

        
        int result = minCoins(amount, coins);
        if (result == -1) {
            System.out.println("Tidak mungkin mencapai jumlah target dengan koin yang tersedia.");
        } else {
            System.out.println("Jumlah minimum koin yang dibutuhkan: " + result);
        }
    }
}
