class Solution {
    public int search(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            m.put(nums[i], i);
        }

        for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if(entry.getKey() == target) return entry.getValue();
        }

        return -1;
    }
}