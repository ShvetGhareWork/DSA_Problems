class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxValue = 0;

        for(int i = 0; i < n; i++){
            maxValue = Math.max(maxValue, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxValue);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = prefixGcd.length - 1;
        long sum = 0;

        while(left < right){
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }
        private static int gcd(int a, int b){
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