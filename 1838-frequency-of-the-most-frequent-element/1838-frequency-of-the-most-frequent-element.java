class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        long res = 0, total = 0;

        while (right < nums.length) {
            total += nums[right];

            while (nums[right] * (right - left + 1L) > total + k) {
                total -= nums[left];
                left += 1;
            }

            res = Math.max(res, right - left + 1L);
            right += 1;
        }

        return (int) res;        
    }
}
// Dont look at the numbers here the main idea behind this sum lies in the sliding windown technique
// if the window has like [3,3,3] we know that the max frequency is going to be 3 how do we obtain it?
// we get the window, left and right the total sum inside that window and the length of that window as well.
// we consider that the element present at the nums[right] is the one we need to mapp the frequency for.
// to check if when all the same frequency is inside the window is less then one point then what is the total value of the window plus the k provided.
// once we get to know it. if its less then we increment the frequency stating that yes this windown can be done and the frequency is this this as mentioned,
// if not then we increment the left pointer and decrease the sum further.