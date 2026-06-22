class Solution {
    public boolean check(int[] nums) {
          int n = nums.length;

        int drops = 0;

        for(int i = 0; i < n; i++) {
            /* Why % n because to carry on circular traversal last elemetn should be compareed to the first element
            so we know that after last element there is nothing. but as we see the loop there is not n - 1 with means there will be a extra iteration which implies that nums[i+1] will be equal to the length at the final iteration. and we know the modulo of the same numbers is equal to zero which means the last and the first element will be compared. Hence, got what we wanted!
            */
            
            if(nums[i] > nums[(i + 1) % n]) {
                drops++;
            }
        }

        return drops <= 1;
    }
}