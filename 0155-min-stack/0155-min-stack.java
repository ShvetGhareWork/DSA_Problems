class MinStack {
    private List<int[]> stack;
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        int top[] = stack.isEmpty() ? new int[]{value, value} : stack.get(stack.size() - 1);
        int minValue = top[1];
        if(minValue > value) minValue = value;
        stack.add(new int[]{value, minValue});
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1)[0];
    }
    
    public int getMin() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */