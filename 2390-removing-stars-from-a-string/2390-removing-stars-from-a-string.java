class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int j = n - 1;
        int count = 0;
        while (j >= 0) {
            char c = s.charAt(j);
            if (c == '*') {
                count++;

            } else if (count == 0) {
                sb.append(c);
            } else if (count != 0) {
                count--;
            }
            j--;

        }

        return sb.reverse().toString();
    }
}