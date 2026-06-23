class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int threshold = nums.length / 2;
        
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (count > threshold) {
                return num;
            }
        }
        
        return -1; // Should never reach here given problem constraints
    }
}