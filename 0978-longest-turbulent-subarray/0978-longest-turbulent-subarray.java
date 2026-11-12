class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n <= 1) return 1;

        int left = 0;
        int maxLength = 1;
        int prev = 0;

        for(int right = 1; right < n; right++){
            if(arr[right] > arr[right - 1]){
                if(prev == -1){
                    maxLength = Math.max(maxLength, right - left + 1);
                    prev = 1;
                }else {
                    left = right - 1;
                    prev = 1;
                }
            }
            else if(arr[right] < arr[right - 1]){
                if(prev == 1){
                    maxLength = Math.max(maxLength, right - left + 1);
                    prev = -1;
                }else {
                    left = right - 1;
                    prev = -1;
                }
            }
            else{
                left = right;
                prev = 0;
            }
        }
        maxLength = Math.max(maxLength, n - left);
        return maxLength;
    }
}