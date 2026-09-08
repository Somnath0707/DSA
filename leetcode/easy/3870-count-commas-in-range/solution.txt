class Solution {
    public int countCommas(int n) {
        int total = 0 ; 

        if( n >= 1000){
            total += n - 1000+1  ; 
        }


        if(n >= 1000000){
            total += n - 1000000 +1 ;
        }


        if(n>=1000000000){
            total += n - 1000000+1;
        }

        return total;
    }
}