class Solution {
    public int numberOfChild(int n, int k) {
        int lastChild = n - 1;
        int cycleLength = 2 * lastChild;
        int positionInCycle = k % cycleLength;

        if (positionInCycle <= lastChild) {
            return positionInCycle;
        } else {
            return cycleLength - positionInCycle;
        }
    }
}