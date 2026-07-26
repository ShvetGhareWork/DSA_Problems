class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        helper(0, 0, "", n, result);
        return result;
    }
    private void helper(int left, int right, String s, int n, List<String> result){
        if(s.length() == n * 2){
            result.add(s);
            return;
        }
        if(left < n) helper(left + 1, right, s + "(", n, result);
        if(right < left) helper(left, right + 1, s + ")", n, result);
    }
}