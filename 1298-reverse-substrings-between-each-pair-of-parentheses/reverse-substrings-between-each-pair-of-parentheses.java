class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == ')'){
                StringBuilder temp = new StringBuilder();

                while(!stack.isEmpty() && stack.peek() != '('){
                    temp.append(stack.pop());
                }

                // pop the (
                stack.pop();
                
                for(char c : temp.toString().toCharArray()){
                    stack.push(c);
                }
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}


//(abcd) -> dcba