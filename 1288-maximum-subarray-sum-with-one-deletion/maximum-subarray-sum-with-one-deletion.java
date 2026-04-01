class Solution {
    Integer[][] dp;
    public int f(int i , int canDelete , int arr[]){
        if(i >= arr.length) return Integer.MIN_VALUE ; 

        String key = i + "#" + canDelete;

        if(dp[i][canDelete ] != null) return dp[i][canDelete];

        int take = arr[i]; 

        if(i + 1 < arr.length){
            take = Math.max(take , arr[i] + f(i+ 1, canDelete , arr));
        }

        int skip = Integer.MIN_VALUE;
        if( canDelete == 1 && i < arr.length ){
            skip = f(i+1 , 0  , arr);
        }

        int ans =  Math.max(take , skip ) ; 

        dp[i][canDelete] = ans ; 
        return ans; 
    }
    public int maximumSum(int[] arr) {
        
        int n = arr.length ;
        int ans = Integer.MIN_VALUE; 
        dp = new Integer[n][2];
        for(int i = 0 ; i < n ; i ++){
            ans = Math.max( ans , f(i , 1 , arr));
        }
        return ans; 
    }
}



// ''' arr = [1,-2,0,3] -> 1 -1 ,-1  2  : 3 , 3 , 1  , 2 
// use the kadhane alogorithm like take the element if there and sum it if the answer reduces we can skip once and if again we get the answer less than the starting point fck that 

// check the max in the array  if the answer is lower than that , that could seriously cant be answer 

// so if there come a time where the sum reduces less than starting sum curr we can skip that and move forward to the next positive element

// ex arr = [1,-2,-2,3] take 1 ok sum 1 hell yeah , take -2 oh no negative sum dec its ok we ignore one shitty brat , lets move take -2 nah hell naw we aint taking 2 of these brat no fcking way max sum = 1 move to next of the curr take 3 max sum = 3 move end of arry we got it 

// ex arr = [1,-2,0,3] -> take 1 ok sum = 1 lets go , take -2 ok one shitty brat is still fine sum = 1 brat = 1 , next 0 ok total is not decreaing so lets take him total sum = 1 max = 1 
// next 3 ok take him 3 + 1 = 4 sum = 4 , max sum = 4 ned of array ans = 4 


// ex[-1 , -1 , -1 . -1 ] take -1 sum = -1 take next -1 ok skip this brat , next -1 nah aint happening move to the next -1 sum = -1 total sum -1 nah end of array max = -1 '''
