class Solution {
    public boolean parseBoolExpr(String s) {
       Stack<Character> stack = new Stack <>();

       for(char ch : s.toCharArray() ) {
        if(ch == ',') continue; 

        if(ch != ')') {
            stack.push(ch);
            continue;
        }
        int tcount = 0; 
        int fcount = 0; 
        while(stack.peek() != '('){
            char curr = stack.pop();
            if (curr == 't') tcount++;
            else if (curr == 'f') fcount++;
        }
        stack.pop(); //remove the reamining )

        char op = stack.pop(); // pop the operator

        char res = 'f';

        if (op == '!') {
            res = (fcount == 1) ? 't' : 'f';
         } else if (op == '&') {
            res = (fcount == 0) ? 't' : 'f';
        } else if (op == '|') {
            res = (tcount > 0) ? 't' : 'f';
        }

        stack.push(res);

       } 
       return ( stack.peek()== 't' )? true: false; 
    }
}