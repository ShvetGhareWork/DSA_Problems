class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        int limit = n*2;

        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                sumEven += i; // Correct: Adds 'i' to the current sum
            } else {
                sumOdd += i; // Correct: Adds 'i' to the current sum
            }
        }
        return findGCD(sumOdd, sumEven);
        // return sumOdd;
        // return sumEven;
    }

    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}