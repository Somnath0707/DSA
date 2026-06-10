class Solution {
    int dp[]; 
    public int f(int i , String s , Set<String> set){
        if(i == s.length()){
            // System.out.println("current word is : " + temp);
            // if(set.contains(temp)) return temp.length();
            return 0 ; 
        }

        if(dp[i] != -1 ) return dp[i] ; 
        int ans = 1 + f(i+1 , s , set); 

        for(int j = i ; j < s.length() ; j++){
            String curr = s.substring(i , j+1);

            if(set.contains(curr)){
                ans = Math.min(ans , f(j+1 , s , set));
            }
        }
        
        return dp[i] = ans ; 
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(); 
        for(String str : dictionary ){
            set.add(str);
        }
        dp = new int[s.length()]; 
        Arrays.fill(dp, -1 ) ; 
        return f(0 , s , set);
    }
}