class Solution {
    public String removeKdigits(String num, int k) {
        // Stack to store the char
        Stack<Character> stack = new Stack<>();

        // go throught the nums 
        // if we find any value less than the curr in the stack then we pop that from stack and push the curr value in the stack 
        // And we reduce the k 
        for(char n : num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek() > n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        // If there we still the value that were left in case like {1,2,3,4,5} and k =2 then we can remove the value from the back that is top of the stack till k = 0;  
        while( k >0){
                stack.pop();
                k--;
            }
        
        // If the stack becomes empty we can return just 0
        if(stack.isEmpty()) return "0";

        // String to store the new answer 
        StringBuilder ans = new StringBuilder();

        // put the value from the stack to the string 
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        // reverse the string 
        ans.reverse();


        // if there are any leading 0s then we should trim them 
        while(ans.length() > 1 && ans.charAt(0) =='0')
            ans.deleteCharAt(0);

        // return the answer in the form of the string as requested 
        return ans.toString();
    }
}