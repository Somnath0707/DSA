class Solution {
    int chooice[][] ; 
    int dp[][] ; 

    public boolean getHamming(String one , String two){
        if(one.length() != two.length()) return false; 
        int count = 0 ; 
        int n = one.length(); 
        for(int i = 0 ; i < n ; i++){
            char a = one.charAt(i); 
            char b = two.charAt(i); 
            if(a != b) count++ ; 
            if(count > 1) return false; 
        }
        if(count < 1) return false; 
        return true; 
    }
    public int f(int i , int prev , int n  , String words[] , int groups[]){
        if( i == n ){
            return 0 ; 
        }

        if(dp[i][prev+1] != -1) return dp[i][prev+1]; 
        int take = 0 ; 
        int skip = 0 ; 

        if( prev == -1){
            take = 1 + f(i+1 , i , n , words , groups); 
        }

        else if(groups[i] != groups[prev] && getHamming(words[i] , words[prev])){
            take = 1 + f(i + 1 , i , n , words , groups); 
        }
        skip = f(i+1 , prev , n , words , groups); 

        if(take > skip){
            chooice[i][prev+1] = 1; 
            dp[i][prev+1] = take; 
        }
        else{
            chooice[i][prev+1] = 0 ; 
            dp[i][prev+1] = skip ; 
        }

        return dp[i][prev+1]; 

       
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length; 
        dp = new int[n][n+1];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1) ; 
        }

        chooice = new int[n][n+1]; 
        f(0 , -1  , n , words , groups );

        List<String> list = new ArrayList<>(); 
        int i = 0 ; 
        int prev = -1; 

        while(i < n ){
            if(chooice[i][prev+1] == 1){
                list.add(words[i]);
                prev = i ; 
            }
            i++; 
        }

        return list; 
    }
}