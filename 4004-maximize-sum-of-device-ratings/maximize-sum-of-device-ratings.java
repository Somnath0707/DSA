class Solution {
    public long maxRatings(int[][] units) {
        long sum = 0 ; 
        int n = units.length; 
        long  worst = Integer.MAX_VALUE;
        long smallest = Integer.MAX_VALUE; 
        long ans = 0 ; 
        if(units[0].length == 1 ) {
            for(int i = 0 ; i < n ; i++){
                ans += units[i][0]; 
            }
            return ans;
        }
        for(int i = 0 ; i < n ; i++){
            long firstSmall = Integer.MAX_VALUE; 
            long secondSmall = Integer.MAX_VALUE; 
            for(int num : units[i]){
                if(num < firstSmall){
                    secondSmall = firstSmall; 
                    firstSmall = num ; 
                    
                }
                else if ( num < secondSmall){
                    secondSmall = num; 
                }
                smallest = Math.min(firstSmall , smallest ) ; 
            }
            if(secondSmall == Integer.MAX_VALUE) secondSmall = firstSmall ; 
            sum += secondSmall;  
            worst = Math.min(worst , secondSmall);
        }
        return sum - worst + smallest ;
    }
}