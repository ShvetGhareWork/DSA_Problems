class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middleChar = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                char c = (char) ('a' + i);
                
                if (count[i] % 2 != 0) {
                    middleChar = c;
                    for (int j = 0; j < (count[i] - 1) / 2; j++) {
                        firstHalf.append(c);
                    }
                } else {
                    for (int j = 0; j < count[i] / 2; j++) {
                        firstHalf.append(c);
                    }
                }
            }
        }

        String first = firstHalf.toString();
        String second = firstHalf.reverse().toString();

        if (middleChar != 0) {
            return first + middleChar + second;
        } else {
            return first + second;
        }
    }
}