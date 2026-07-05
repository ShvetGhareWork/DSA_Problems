class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        for(int num : nums){
            int count = numMap.getOrDefault(num, 0) + 1;
            numMap.put(num, count);
        }

        for(Map.Entry<Integer, Integer> entry : numMap.entrySet()){
            if(entry.getValue() > threshold) result.add(entry.getKey());
        }

        return result;
    }
}