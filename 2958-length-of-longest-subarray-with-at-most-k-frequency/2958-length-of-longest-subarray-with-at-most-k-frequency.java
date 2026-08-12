class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = 1;
        int left = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int right = 0; right < n; right++){
                int num = nums[right];
                map.put(num, map.getOrDefault(num, 0) + 1);
                while(map.get(num) > k){
                    int d = nums[left];
                    map.put(d, map.get(d) - 1);
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }

        return result;
    }
}