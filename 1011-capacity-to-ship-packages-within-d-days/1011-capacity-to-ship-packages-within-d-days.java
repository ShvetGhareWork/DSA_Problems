class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; 
        int right = 0;

        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int curr = 0;
            int requirement = 1;
            for(int num : weights){
                if(curr + num > mid){
                    requirement += 1;
                    curr = 0;
                }
                curr += num;
            }

            if(requirement > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}