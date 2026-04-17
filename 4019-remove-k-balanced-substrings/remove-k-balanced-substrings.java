class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Character> stack = new Stack<>();

        int open = 0 ; 
        int close = 0 ; 
        boolean isClose = false; 
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(isClose){
                    open = 1 ;
                    close = 0 ;
                    stack.push('(');
                    isClose = false ; 
                }else{
                    open ++; 
                    stack.push('(');
                }
            }

            if(ch == ')'){
                isClose = true; 
                close ++ ; 
                stack.push(')');
            }


            if(stack.size() >= 2*k){
                boolean valid = true;

                // check last k are ')'
                for(int t = 0; t < k; t++){
                    if(stack.get(stack.size() - 1 - t) != ')'){
                        valid = false;
                        break;
                    }
                }

                // check previous k are '('
                for(int t = k; t < 2*k && valid; t++){
                    if(stack.get(stack.size() - 1 - t) != '('){
                        valid = false;
                        break;
                    }
                }

                if(valid){
                    for(int t = 0; t < 2*k; t++){
                        char temp = stack.pop();
                        if(temp == '(') open--;
                        else close--;
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder("");
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}


// If the string Start with th ) we keep it as we can only remove the once that are () and have k number of it

// So we can take the boolean value isOpen isClose to check which of the current is running once both the running ends we can check if the both of them are above the k 
// If so we can pop them until one of them goes less than k than if the we have 
// ())())) open 2 close 3 we also have to check if the streak of open is there like 
// if there is close in middle and both have we cant be balnaced so check first the current strek of the '(' and then once the ')' we check if the braces are both >= to k at that point we pop them if the new ( comes we know that we did not get the answr then we start again from the like close = 0 open is 0 so we can keep boolean isClose if we get the new ( and isClose is true we put 0 , 0 to both of them and start couting for the new () braces and check condidtion and after that just print the remainng in the stack 