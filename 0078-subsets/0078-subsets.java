class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subsetSum(0, nums, new ArrayList<>(), result);
        return result;
    }
    private void subsetSum(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        subsetSum(index + 1, nums, subset, result);

        subset.remove(subset.size() - 1);
        subsetSum(index + 1, nums, subset, result);
    }
}