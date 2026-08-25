class Solution {
    Integer dp[][]; 
    public int bs(int currEnd , int nums[][]){
        int left = 0 ; 
        int right = nums.length-1; 
        int ans = -1 ; 

        while(left <= right){
            int mid = left + (right-left)/2; 

            if(nums[mid][0] > currEnd){
                ans = mid; 
                right = mid-1; 
            }else{
                left = mid+1; 
            }
        }
        if(ans == -1) return nums.length; 
        return ans; 
    }
    public int f(int i , int newK , int k , int[][] nums){
        if(k == newK) return 0 ; 
        if(i == nums.length){
            if(newK <= k) return 0 ; 
            return Integer.MIN_VALUE; 
        }
        if(dp[i][newK]!= null) return dp[i][newK]; 
        int take = Integer.MIN_VALUE; 
        int skip = Integer.MIN_VALUE; 

        int start = nums[i][0]; 
        int end = nums[i][1]; 
        int val = nums[i][2]; 

        int nextVal = bs(end , nums); 
        int tempK = newK+1; 
        take = val + f(nextVal , tempK , k , nums );

        skip = f(i+1 , newK , k , nums); 

        int ans = Math.max(take , skip); 


        return dp[i][newK] =  ans; 




    }
    public int maxValue(int[][] events, int k) {
        // The constraints that i see now are like new it says k * events.length is <=10^6 so if i do two state dp the dp will never exceed 10^6
        Arrays.sort(events , (a,b)-> {
            if(a[0]!=b[0]) return Integer.compare(a[0] , b[0]);
            return Integer.compare(a[1],b[1]);// i think this wont matter much; 
        });
        int n = events.length; 
        dp = new Integer[n][k+1]; 
        return f(0 , 0 , k , events); 
    }
}