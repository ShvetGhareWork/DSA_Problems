import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        // Determine the range of lengths to check
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len = lowLen; len <= highLen; len++) {
            // Try every starting position for this length
            for (int start = 0; start <= 9 - len; start++) {
                // Extract the sequential number substring
                String sub = digits.substring(start, start + len);
                int num = Integer.parseInt(sub);

                // Check if it falls within the range [low, high]
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        // The numbers generated are naturally sorted because we iterate by length then start index
        return result;
    }
}