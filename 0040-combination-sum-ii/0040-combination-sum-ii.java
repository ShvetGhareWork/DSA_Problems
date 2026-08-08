class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        recursiveDfs(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void recursiveDfs(int[] candidates, int target, int start, 
    List<Integer> combination, List<List<Integer>> result){
        if(target < 0) return;

        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue; //For duplicates
            if(candidates[i] > target) break;

            combination.add(candidates[i]);
            recursiveDfs(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}