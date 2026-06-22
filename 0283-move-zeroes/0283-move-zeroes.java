class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == 0 && nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }else if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
            }
        }

        System.out.println(nums);
    }
}