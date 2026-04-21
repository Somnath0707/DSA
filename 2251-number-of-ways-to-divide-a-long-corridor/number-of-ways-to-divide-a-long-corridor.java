class Solution {

    int MOD = 1000_000_007;
    public int numberOfWays(String s) {
        // Group them in group of 2 
        int total = 0 ; 
        for(char ch : s.toCharArray()){
            if(ch == 'S') total ++ ; 
        }
        if(total % 2 != 0 || total == 0 )  return 0 ; 
        List<int[]> list = new ArrayList<>();

        int countSeats = 0 ; 
        int i = 0 ; 
        int j = 0 ;  
        while(j < s.length()){
            if(s.charAt(j) == 'S'){
                countSeats++;
            }

            if(countSeats  == 1 &&s.charAt(j) == 'S' ){
                i = j ;
            }

            if(countSeats == 2){
                list.add(new int[]{i , j });
                countSeats = 0 ; 
            }
            j++;
        }

        // Traves this and get the sub of the last of the prev and first of the curr and mul them to the answer and & Mod ;
        long ways = 1 ; 
        if(list.size() >= 2 ){
            for(int k = 1 ;  k < list.size() ; k++){
                int prev [] = list.get(k-1);
                int curr[] = list.get(k);
                ways = (ways * (curr[0] - prev[1])) % MOD;
            }
        }
        return (int)(ways );
    }
}