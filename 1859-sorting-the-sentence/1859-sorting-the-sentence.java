class Solution {
    public String sortSentence(String s) {
        String[] tokens = s.split(" ");
        String[] str = new String[tokens.length + 1];

        for(String token : tokens){
            int number = token.charAt(token.length() - 1) - '0';
            str[number] = token.substring(0, token.length() - 1);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 1; i < str.length; i++){
            if(i > 1) result.append(" ");
            result.append(str[i]);
        }

        return result.toString();
    }
}