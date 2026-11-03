class Solution {
    public int minMoves(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for(int num : nums) if(num > maxElement) maxElement = num;
        long moves = 0;
        for(int num : nums) moves += maxElement - num;
        return (int) moves;
    }
}