class Solution {
    int nums[][];
    Long dp[][][][][]; 
    int MOD = 1000000007;
    public int f( int i , int j  , int n){
        // last cell 
        if(i == n) return 1 ; 
        if(j == 3 ){
            return f(i+1 , 0 , n );
        }

        int c0;
        if (j > 0) {
            c0 = nums[i][0];
        } else if (i > 0) {
            c0 = nums[i-1][0];
        } else {
            c0 = 3;
        }

        int c1;
        if (j > 1) {
            c1 = nums[i][1];
        } else if (i > 0) {
            c1 = nums[i-1][1];
        } else {
            c1 = 3;
        }

        int c2;
        if (i > 0) {
            c2 = nums[i-1][2];
        } else {
            c2 = 3;
        }


        if(dp[i][j][c0][c1][c2] != null) return (int)(long)dp[i][j][c0][c1][c2];

        long count = 0 ; 
        for(int ind = 0 ; ind < 3 ; ind++){
            // check to left 
            if(j > 0){
                if(nums[i][j-1] == ind) continue;
            }
            if(i > 0){
                if(nums[i-1][j] == ind) continue;
            }

            nums[i][j] = ind;
            count = (count +  f(i , j+1 , n)) % MOD;
            nums[i][j] = -1;
        }

        return (int)(long)(dp[i][j][c0][c1][c2] = count);

    }
    public int numOfWays(int n) {
        nums = new int[n][3];
        dp = new Long[n][4][4][4][4];
        
        // -1 is empty uncolored 
        // 0: red ,1 : yellow ,and 1: gren
        return f(0 , 0 , n );
    }
}

// its a textbook dp problem bro like we have 3 choices at each step more specificaaly we choose at each point looking to the neighours 