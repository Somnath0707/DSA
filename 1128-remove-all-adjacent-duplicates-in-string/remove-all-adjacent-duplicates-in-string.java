class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack <>();
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else if (c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            char a = stack.pop();
            res.append(a);
        }
        String reversed = new StringBuilder(res).reverse().toString();
        return reversed;

    }
}