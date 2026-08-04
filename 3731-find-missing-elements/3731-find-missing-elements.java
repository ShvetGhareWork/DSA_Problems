class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);
        int currElement = nums[0];

        for(int i = 0; i < nums.length; currElement++, i++){
            if(currElement < nums[i]){
                result.add(currElement);
                i--;
            }
        }

        return result;
    }
}