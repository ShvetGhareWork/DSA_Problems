class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }
        
        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() < dire.peek()) radiant.add(n++);
            else dire.add(n++);

            radiant.remove();
            dire.remove();
        }

        if(dire.isEmpty()) return "Radiant";
        return "Dire";
    }
}