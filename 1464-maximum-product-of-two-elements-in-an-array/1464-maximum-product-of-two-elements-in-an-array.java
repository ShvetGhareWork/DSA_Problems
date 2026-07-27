class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int left = nums[nums.length - 1];
        int right = nums[nums.length - 2];

        return (left - 1) * (right - 1);
    }
}