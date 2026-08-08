class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] question = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        recursiveDfs(question, k, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void recursiveDfs(int[] question, int k, int target, int start, List<Integer> combination, List<List<Integer>> result){

        if(target == 0 && k == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        // if (k <= 0 || target <= 0) {
        //     return;
        // }


        for(int i = start; i < question.length; i++){
            combination.add(question[i]);
            recursiveDfs(question, k - 1, target - question[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}