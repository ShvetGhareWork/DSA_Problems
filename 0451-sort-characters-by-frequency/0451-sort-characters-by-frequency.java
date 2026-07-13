class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(char c : s.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(m.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int count = entry.getValue();
            
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        String result = sb.toString();
        return result;
    }
}