class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for(int i = 1; i <= length; i++){
            for(int m = 0, n = m + i - 1; n < length; m++, n++){
                if(m == n)
                    dp[m][n] = 1;
                else if(s.charAt(m) == s.charAt(n))
                    dp[m][n] = 2 + dp[m + 1][n - 1];
                else
                    dp[m][n] = Math.max(dp[m + 1][n], dp[m][n - 1]);
            }
        }

        return dp[0][length - 1];
    }
}