class Solution {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int dp = 1;

        for (int i = 1; i < n; i++) {
            
        
            int targetDiff = (dp % 2 == 0) ? -1 : 1;

            if (nums[i] - nums[i - 1] == targetDiff) {
                dp++;                       // extend
            } else if (nums[i] - nums[i - 1] == 1) {
                dp = 2;                     // start new streak (must begin with +1)
            } else {
                dp = 1;                     // no valid streak
            }
            ans = Math.max(ans, dp);
        }
        return ans == 1 ? -1 : ans;
    }
}   