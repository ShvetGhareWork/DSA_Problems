class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] mult = new int[1501];

        // Precompute divisibility counts
        for (int[] it : items) {
            int fact = it[0];

            for (int f = 1; f <= 1500; f++) {
                if (fact % f == 0)
                    mult[f]++;
            }
        }

        int[] dp = new int[budget + 1];

        for (int[] it : items) {
            int fact = it[0], price = it[1];

            int[] ndp = dp.clone();

            // First purchase: 0/1 Knapsack
            for (int i = budget; i >= price; i--) {
                ndp[i] = Math.max(
                    ndp[i],
                    dp[i - price] + mult[fact]
                );
            }

            // Additional purchases: Unbounded Knapsack
            for (int i = price; i <= budget; i++) {
                ndp[i] = Math.max(
                    ndp[i],
                    ndp[i - price] + 1
                );
            }

            dp = ndp;
        }

        int ans = 0;
        for (int x : dp)
            ans = Math.max(ans, x);

        return ans;
    }
}
