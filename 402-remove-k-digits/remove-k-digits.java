class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char n : num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek() > n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while( k >0){
                stack.pop();
                k--;
            }

        if(stack.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();

        while(ans.length() > 1 && ans.charAt(0) =='0')
            ans.deleteCharAt(0);
        return ans.toString();
    }
}