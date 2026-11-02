class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int anchor = nums[nums.length / 2];
        int moves = 0;
        for (int n : nums)
            moves += Math.abs(n - anchor);
        return moves;
    }
}   