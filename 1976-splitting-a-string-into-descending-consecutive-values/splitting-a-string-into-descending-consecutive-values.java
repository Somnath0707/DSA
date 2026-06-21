class Solution {
    public boolean f(int i ,  long prev , int started ,  String s ) {
        if(i == s.length() && started > 1){
            return true; 
        }

        boolean ans = false; 
        long num = 0 ; 
        for(int j = i ; j < s.length() ; j++){
            int digit = s.charAt(j) - '0';
            num = num * 10 + digit; 

            if(prev == -1 || num == prev-1){
               ans = ans || f(j+1 , num ,started+1, s);
            }
        }

        return ans; 
    }
    public boolean splitString(String s) {
        // constraints are so small it pretty sure its dp or backtracking 

        // so check extend backtrack 
        // check if the number is valid i.e. the value is > 0 and if prev != -1 then curr == prev-1 if val is > thne we backtrack else  if i == n-1 return true; if we check all the chooice then wereturn false;  
        // also the base case should be like if we are on the last and if cur sub string is the last sub string is == prev +1 return 1 ; else return  flase  ; 

        // we can use a for loop and try like string partation
        // then we can try the next chooice 
        return f(0 , -1 ,0,  s); 
    }
}