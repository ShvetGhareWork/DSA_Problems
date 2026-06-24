class Solution {
    public int maxProfit(int[] prices) {
        // Edge case: cannot trade with fewer than 2 days
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        // Start from the second element
        for (int i = 1; i < prices.length; i++) {
            // Calculate potential profit if we sell today
            int currentProfit = prices[i] - minPrice;

            // Update maxProfit if current is better
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            // Update minPrice if today is cheaper
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}