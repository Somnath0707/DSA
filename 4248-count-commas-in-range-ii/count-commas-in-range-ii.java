class Solution {
    public long countCommas(long n) {
        long totalcomma = 0 ; 

        if( n >= 1000){
            totalcomma += (long) (n - 1000L + 1);
        }


        if( n >= 1000000){
            totalcomma += (long) (n - 1000000L + 1);
        }


        if( n >= 1000000000L){
            totalcomma += (long) (n - 1000000000L + 1);
        }

        if( n >=1000000000000L){
            totalcomma +=(long) (n-1000000000000L + 1 );
        }

        if(n>= 1000000000000000L){
            totalcomma += (long)(n-1000000000000000L + 1 );
        }

        return totalcomma;
    }
}