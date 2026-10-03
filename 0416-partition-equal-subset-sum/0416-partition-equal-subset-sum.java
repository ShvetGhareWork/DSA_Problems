class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;

        // boolean[] dp = new boolean[targetSum + 1];
        // dp[0] = true;

        // for(int num : nums){
        //     for(int currSum = targetSum; currSum >= num; currSum--){
        //         dp[currSum] = dp[currSum] || dp[currSum - num];
        //         if(dp[targetSum]) return true;
        //     }
        // }


        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        for(int i = 0; i <= nums.length; i++){
           dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            int num = nums[i - 1];

            for(int j = 0; j <= targetSum; j++){
                dp[i][j] = dp[i - 1][j];

                if(j >= num){
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                }
            }

            if(dp[i][targetSum]) return true;
        }

        return dp[nums.length][targetSum];
    }
}