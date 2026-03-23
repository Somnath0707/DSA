class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long totalsum = 0 ; 

        for(int i = 1 ; i < n+1 ; i++){
            totalsum += i ;
        }

        if( Math.abs(target) > totalsum || (totalsum - target) % 2 != 0 ) return new int[] {} ;

        long take = (totalsum - target) / 2 ;

        int num[] = new int[n];

        boolean neg [] = new boolean [n+1];


        for(int i = n ; i >= 1 ; i--){
            if(take >= i ){
                neg[i] = true; 
                take -= i;
            }
        }
        int ind = 0 ; 

        for(int i = n ; i >= 1 ; i--){
            if(neg[i]){
                num[ind++] = -i;
            }
        }

        for(int i = 1 ; i < n+1 ; i++){
            if(!neg[i]){
                num[ind++] = i ;
            }
        }

        
        return num;
        

    }
}