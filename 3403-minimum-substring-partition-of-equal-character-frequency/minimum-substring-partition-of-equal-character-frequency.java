class Solution {
    int dp[]; 
    public boolean check(int freq[]){

        int prev = -1; 
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] ==0) continue; 
            if(prev ==-1 && freq[i] != 0 ){
                prev = freq[i]; 
            }
            else if(prev != -1 && freq[i] != prev){
                return false; 
            }
        }

        return true; 
    }
    public int f(int i , String s){
        int n = s.length();
        if(i == n){
            return 0 ; 
        }
        if(dp[i] != -1 ) return dp[i]; 
        int ans = Integer.MAX_VALUE ; 
        int freq[] = new int[26]; 
        for(int ind = i ; ind < n ; ind++){
            int val = s.charAt(ind) -'a'; 
            freq[val]++; 
            if(check(freq)){
                ans = Math.min(ans , 1 + f(ind+1 , s) );
            }
        }
        return dp[i] = ans; 
    }
    public int minimumSubstringsInPartition(String s) {
        // at each point we have just two option either extend the substring or break it to and check 
        // but we can only cut if all the character have same occ 
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp , -1); 
        return f(0 , s); 
    }
}