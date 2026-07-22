class Solution {
    public int largestAltitude(int[] gain) {
        int values = 0;
        int maxValue = 0;

        for(int num : gain) {
            values += num;
            maxValue = Math.max(maxValue, values);
        }

        return maxValue;
    }
}