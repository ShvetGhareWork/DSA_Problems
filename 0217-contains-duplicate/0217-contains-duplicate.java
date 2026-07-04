class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(nums[i])) return true;
            numMap.put(nums[i], i);
        }

        return false;
    }
}