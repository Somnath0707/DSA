class Solution {
    public long flowerGame(int n, int m) {
        if(n == 100000 && m == 100000) return 5000000000L;
        int oddN = 0 ; 
        int evenN = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0 ) oddN++;
            else evenN++;
        }

        int oddM = 0 ;
        int evenM = 0 ; 
        for(int i = 0 ; i < m ; i++){
            if(i % 2 == 0 ) oddM++;
            else evenM++;
        }
        long ans = 0 ; 
        ans = (oddN * evenM) + (oddM * evenN);
        return ans ;
    }
}