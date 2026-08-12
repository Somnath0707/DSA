class Solution {
    public boolean canBeValid(String s, String lock) {
        // first should be open and last should be closed 
        // ))())) -> 0 1 0 1 0 0 
        // canChangeClose and open 
        // (
        // () fixed 
        // ()( canChage = 1 to close 
        // ()() fixed can chnage =0 ; 
        // ()()) can change = 1 
        // ()())) its last so do we have beofre which we can change yeah remove 0 we can get answer 

        // we keep like track of canopen can close var which tells can we open or close the before and open and close 

        // first and last shoud be open and close respectively 
        // locked should be helped with the unloced or can open and can close 

        int canChange = 0 ; 
        int canClose = 0 ;
        int open = 0 ; 
        int close = 0 ; 
        int n = s.length(); 
        if(n % 2 != 0) return false;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            int locked = lock.charAt(i)-'0';

            if(i == 0 && ch ==')' && locked == 1) return false; 
            if(i == n-1 && ch == '(' && locked == 1 ) return false; 


            if(locked == 0 ){
                canChange++; 
                open--; 
            }
            else{
                if(ch == '('){
                    // if current is locked then all should be complete then like either all should open or open and close should be same atleast 
                    canChange++; 
                    open++; 
                }
                else{
                    canChange--; 
                    open--; 
                }
            }

            if(canChange < 0) return false;
            if(open < 0) open = 0 ; 



        }
        if(open == 0) return true; 
        return false; 
    }
}