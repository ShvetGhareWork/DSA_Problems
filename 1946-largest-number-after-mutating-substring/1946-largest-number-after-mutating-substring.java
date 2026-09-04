class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] str = num.toCharArray();
        int n = str.length;
        boolean isMutated = false;
        for(int i = 0; i < n; i++){
            int old = str[i] - '0';
            int d = change[old];
            if(d > old){
                str[i] = (char)(d + '0');
                isMutated = true;
            }

            if(d < old && isMutated) break;
        }

        return new String(str);
    }
}