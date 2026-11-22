class Solution {
    public boolean checkString(String s) {
        boolean isTrue = true;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') isTrue = false;
        }

        return isTrue;
    }
}