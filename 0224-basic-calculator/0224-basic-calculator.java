class Solution {
    public int calculate(String s) {
        int curr = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                curr = curr * 10 + (c - '0');
            }
            else if(c == '+'){
                result += curr * sign;
                sign = 1;
                curr = 0;
            }
            else if(c == '-'){
                result += curr * sign;
                sign = -1;
                curr = 0;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                curr = 0;
            }
            else if(c == ')'){
                result += curr * sign;
                curr = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        result += sign * curr;
        return result;
    }
}