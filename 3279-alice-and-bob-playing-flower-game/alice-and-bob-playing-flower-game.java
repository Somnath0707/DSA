class Solution {
    public long flowerGame(int n, int m) {
        long oddN = 0 ; 
        long evenN = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0 ) oddN++;
            else evenN++;
        }

        long oddM = 0 ;
        long evenM = 0 ; 
        for(int i = 0 ; i < m ; i++){
            if(i % 2 == 0 ) oddM++;
            else evenM++;
        }
        long ans = 0 ; 
        ans = (oddN * evenM) + (oddM * evenN);
        return ans ;
    }
}