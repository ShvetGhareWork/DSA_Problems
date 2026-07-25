class Solution {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();

        while(n != 0){
            int num = n % 10;
            list.add(num);
            n /= 10;
        }
        Collections.sort(list);

        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }
}