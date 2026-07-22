class Solution {
    public int compress(char[] chars) {
        int write = 0; // Pointer to write the next character
        int read = 0;  // Pointer to read the input

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if it's greater than 1
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}