class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        return Math.max(minimumBound(cost1, cost2, costBoth, need1, need2), minimumBound(cost2, cost1, costBoth, need2, need1));
    }
    public long minimumBound(int cost1, int cost2, int costBoth, long need1, long need2) {
        int priceA = Math.min(cost1, costBoth);
        int priceB = Math.min(cost2, costBoth - priceA);
        return need1 * priceA + need2 * priceB;
    }
}