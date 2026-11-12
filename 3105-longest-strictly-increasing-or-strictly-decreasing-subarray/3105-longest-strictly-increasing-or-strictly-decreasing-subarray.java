class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int countIncreasing = 1;
        int countDecreasing = 1;
        int maxLength = 1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                countIncreasing++;
                countDecreasing = 1;
            } else if (nums[i] > nums[i + 1]) {
                countDecreasing++;
                countIncreasing = 1;
            } else {
                countIncreasing = 1;
                countDecreasing = 1;
            }
            maxLength = Math.max(maxLength, Math.max(countIncreasing, countDecreasing));
        }

        return maxLength;
    }
}