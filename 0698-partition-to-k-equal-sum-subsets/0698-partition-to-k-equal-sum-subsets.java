class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        
        Arrays.sort(nums);

        return canPartitionKSubsetsNow(nums, sum/k, nums.length - 1, new int[k]);
    }
    private boolean canPartitionKSubsetsNow(int[] nums, int target, int index, int[] bucket){
        if(index == -1) return true;

        for(int i = 0; i < bucket.length; i++){
            if(bucket[i] + nums[index] <= target){
                bucket[i] += nums[index];

                if(canPartitionKSubsetsNow(nums, target, index - 1, bucket))
                    return true;

                bucket[i] -= nums[index];

            if(bucket[i] == 0) 
                break;
            }
        }

        return false;
    }
}