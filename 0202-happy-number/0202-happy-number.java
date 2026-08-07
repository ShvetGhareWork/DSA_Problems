class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int newNum = n;

        while(newNum != 1){
            newNum = digitValue(newNum);

            if(set.contains(newNum)) return false;
            set.add(newNum);
        }

        return true;
    }
    private int digitValue(int n) {
        int ans = 0;
        while(n > 0){
            int num = n % 10;
            n /= 10;
            ans += (num * num);
        }

        return ans;
    }
}