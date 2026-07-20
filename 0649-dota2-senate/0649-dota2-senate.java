class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }
        
        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() < dire.peek()) radiant.offer(n++);
            else dire.offer(n++);

            radiant.poll();
            dire.poll();
        }

        if(dire.isEmpty()) return "Radiant";
        return "Dire";
    }
}