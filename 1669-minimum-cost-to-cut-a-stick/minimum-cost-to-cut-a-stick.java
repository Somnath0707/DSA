class Solution {
    
    public int f(int i , int j ,ArrayList<Integer> list , int dp[][]){
        if(i > j ) return 0 ; 

        if(dp[i][j]  != -1 ) return dp[i][j] ; 
        int mini = Integer.MAX_VALUE;
        for(int idx = i ; idx <= j ; idx++){
            int cost = list.get(j +1 ) - list.get(i-1) + f(i , idx-1 , list , dp ) + f(idx + 1 , j , list , dp );
            mini = Math.min(mini , cost ); 
        }
        return dp[i][j] =  mini;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int c : cuts){
            list.add(c);
        }
        int C = cuts.length;

        int dp[][] = new int[C+2][C+2];
        for(int i =0 ; i< C+2 ; i++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        list.add(n);
        Collections.sort(list); 

        return f( 1 , cuts.length , list , dp);
    }
}