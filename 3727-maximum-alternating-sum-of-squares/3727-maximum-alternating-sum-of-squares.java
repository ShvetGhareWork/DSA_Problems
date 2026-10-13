class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] a = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            a[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(a);

        long answer = 0;
        int k = nums.length / 2;

        // Postive values;
        for(int i = 0; i < k; i++) answer -= a[i];

        // Negative values:
        for(int i = k; i < nums.length; i++) answer += a[i];

        return answer;
    }
}