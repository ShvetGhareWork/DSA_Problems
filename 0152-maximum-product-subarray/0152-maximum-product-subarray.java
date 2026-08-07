class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int num : nums)
            result = Math.max(num, result);

        int currMax = 1;
        int currMin = 1;
        for (int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(temp, Math.max(currMin * num, num));
            currMin = Math.min(temp, Math.min(currMin * num, num));

            result = Math.max(result, currMax);
        }

        return result;
    }
}