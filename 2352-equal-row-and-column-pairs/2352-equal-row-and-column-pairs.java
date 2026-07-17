import java.util.*;

class Solution {

    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<List<Integer>, Integer> rowFrequency = new HashMap<>();

        // Store all rows with their frequencies
        for (int row = 0; row < n; row++) {
            List<Integer> values = new ArrayList<>();

            for (int col = 0; col < n; col++) {
                values.add(grid[row][col]);
            }

            rowFrequency.merge(values, 1, Integer::sum);
        }

        int pairs = 0;

        // Create each column and check whether it matches a row
        for (int col = 0; col < n; col++) {
            List<Integer> values = new ArrayList<>();

            for (int row = 0; row < n; row++) {
                values.add(grid[row][col]);
            }

            pairs += rowFrequency.getOrDefault(values, 0);
        }

        return pairs;
    }
}