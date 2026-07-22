class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int totalValue = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            totalValue += nums[right];
            while(totalValue >= target) {
                result = Math.min(result, right - left  + 1);
                totalValue -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}