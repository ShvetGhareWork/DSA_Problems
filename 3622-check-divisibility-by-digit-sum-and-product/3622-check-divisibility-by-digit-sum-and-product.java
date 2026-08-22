class Solution {
    public boolean checkDivisibility(int n) {
        int divisibleSum = 0;
        int originalValue = n;
        int prodValue = 1;
        int sumValue = 0;
        while(n > 0){
            int num = n % 10;
            sumValue += num;
            prodValue *= num;
            n /= 10;
        }

        if(originalValue % (sumValue + prodValue) == 0) return true;

        return false;
    }
}