class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double left = 0;
        double right = 0;
        double n = nums.length;
        double maxValue = Integer.MIN_VALUE;
        double currentSum = 0;

        for(int i = 0; i < k; i++) currentSum += nums[i];
        maxValue = currentSum;

        for(int i = k; i < n; i++){
            currentSum += nums[i];
            currentSum -= nums[i - k];
            maxValue = Math.max(currentSum, maxValue);
        }

        return maxValue/k;
    }
}