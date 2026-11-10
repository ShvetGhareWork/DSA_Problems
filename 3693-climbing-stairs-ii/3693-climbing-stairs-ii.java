class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(3, i); j++) {
                int k = i - j;
                long jump = (long) (i - k) * (i - k);
                dp[i] = Math.min(dp[i], dp[k] + jump + costs[i - 1]);
            }
        }

        return (int) dp[n];
    }
}