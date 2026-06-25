class Solution {
    String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        var list = new ArrayList<String>();
        if(digits==null || digits.length()==0) return list;

        backtrack(0,digits, new StringBuilder(), list);
        return list;
    }
    public void backtrack(int index, String digits, StringBuilder sb, ArrayList<String>list) {
        if(index==digits.length()){
            list.add(sb.toString());
            return;
        }
        for(char c: arr[digits.charAt(index)-'0'].toCharArray()) {
            int len = sb.length();
            sb.append(c);
            backtrack(index+1, digits, sb, list);
            sb.setLength(len);
        }
    }
}