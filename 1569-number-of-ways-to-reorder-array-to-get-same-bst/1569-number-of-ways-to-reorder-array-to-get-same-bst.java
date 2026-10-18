class Solution {
    private static final long MOD = 1_000_000_007L;
    private long c[][];
    public int numOfWays(int[] nums) {
        int n = nums.length;
        c = new long[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            c[i][0] = 1;
            for(int j = 1; j <= i; j++){
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        
        return (int) ((ways(list) - 1 + MOD) % MOD);
    }

    private long ways(List<Integer> list){
        int size = list.size();
        if (size <= 2) return 1;

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 1; i < size; i++) {
            int x = list.get(i);
            if (x < root) left.add(x);
            else right.add(x);
        }

        long res = c[size - 1][left.size()];
        res = res * ways(left) % MOD;
        res = res * ways(right) % MOD;
        return res;
    }
}