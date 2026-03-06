class Solution {
    public boolean f(int i , Set<String> set , String s , Boolean dp[]){
        if(i >= s.length()) return true; 

        if(dp[i] != null ) return dp[i] ; 

        for(int j = i ; j < s.length() ; j++){
            String curr = s.substring(i , j + 1 );
            if(set.contains(curr) && f(j+1 , set , s , dp ) ){
                
                return dp[i] = true;
            }
        }
        return dp[i] = false; 
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet <>();

        for(int i = 0; i< wordDict.size() ; i++){
            set.add(wordDict.get(i));
        }

        Boolean dp[] = new Boolean [s.length()];

        return f(0 , set , s , dp);
    }
}