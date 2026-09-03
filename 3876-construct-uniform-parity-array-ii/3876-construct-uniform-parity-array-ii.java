class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = nums1[0];
        int odd = 0;

        for(int num : nums1){
            minVal = Math.min(minVal, num);
            odd |= num & 1;
        }

        return (minVal & 1) == odd;
    }
}