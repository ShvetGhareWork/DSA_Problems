class Solution {
    public int longestSubsequence(int[] nums) {
        int total = 0;
        int length = nums.length;
        boolean nonZero = false;

        for(int num : nums){
            nonZero |= num > 0;
            total ^= num;
        }

        if(!nonZero) return 0;
        return total == 0 ? length - 1 : length;
    }
}