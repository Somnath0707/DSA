class Solution {
    public long lastInteger(long n) {
        long num = n; 
        if(n % 2 == 0) num = n/2; 
        else num = n/2 + 1; 
        
        long temp = num; 

        long side = 0; 
        long left = 0; 
        long right = 0; 
        

        long skipSize = 1; 

        while(num != 1) {
            if(num % 2 != 0) {
                num = num / 2 + 1; 
                if(num == 1) break; 
                
                if(side == 1) side = 0; 
                else side = 1; 
            }
            else if(num % 2 == 0) { 
                num = num / 2; 
                
                if(side == 0) {
                    left += skipSize; 
                }
                else {
                    right += skipSize; 
                }
                if(num == 1) break; 
                if(side == 0) side = 1; 
                else side = 0; 
            }
            skipSize *= 2; 
        }
        
        long ans = 0; 
        
        if(side == 1) {
            long number = temp - right; 
            ans = 2 * number - 1;
        }
        if(side == 0) { 
            long number = left + 1;
            ans = 2 * number - 1; 
        }
        
        return ans; 
    }
}