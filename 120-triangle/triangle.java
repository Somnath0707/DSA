class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int total = list.size();
        int dp[][] = new int[total][total];
        for(int j =0 ; j< total ; j++){
            dp[total-1][j] = list.get(total-1).get(j);
        }
            for(int i = total-2 ; i>=0 ;i--){
                int down = 0; 
                int diagonal =0 ; 
                for(int k = i ; k >=0 ; k--){
                    down = list.get(i).get(k) + dp[i+1][k];
                    diagonal = list.get(i).get(k) + dp[i+1][k+1];

                    dp[i][k] = Math.min(down , diagonal);
                }
            }
        
        return dp[0][0];
    }
}