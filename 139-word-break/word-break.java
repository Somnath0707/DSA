class Solution {
    public boolean f(int i , Set<String> set , String s , Boolean dp[]){
        int n = s.length();
        if( i >= n ) return true ; 

        if(dp[i] != null) return dp[i];

        for(int j = i ; j < n ; j++){
            String curr = s.substring(i , j+1 );
            if(set.contains(curr) ){
                if(f( j + 1  ,set, s , dp))
                return dp[i]=  true;
            }
        }
        return dp[i] = false;
    }
    public boolean wordBreak(String s, List<String> list) {
        Set<String> set = new HashSet<>();
        for(int i =0 ; i < list.size() ; i++){
            set.add(list.get(i));
        }
        int n = s.length();

        Boolean dp[] = new Boolean [n];

        

        return f(0 , set , s ,dp) ; 


    }
}