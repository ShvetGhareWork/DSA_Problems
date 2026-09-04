class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
   
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxValue = Math.max(maxValue, nums[i]);
            int score = maxValue - suffix[i];
            if(score <= k) 
                return i;
        }

        return -1;
    }
}