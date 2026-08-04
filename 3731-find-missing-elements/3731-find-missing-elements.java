class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
            set.add(num);
        }

        for(int i = min + 1; i <= max; i++){
            if(!set.contains(i)) result.add(i);
        }

        return result;
    }
}