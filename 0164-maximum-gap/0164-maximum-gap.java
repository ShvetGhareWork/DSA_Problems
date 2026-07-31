class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length == 0 || nums.length < 2) return 0;
        int maxDifference = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            if(j < nums.length){
                int currDifference = Math.abs(nums[i + 1] - nums[i]);
                maxDifference = Math.max(maxDifference, currDifference);
            }
            else break;
        }

        return maxDifference;
    }
}