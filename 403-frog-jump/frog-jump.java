class Solution {
    
    public boolean f(int i , int k , int nums[] , Map<Integer , Integer> map , Boolean dp[][]){
        if(i == nums.length - 1 ) return true;
        if(k <= 0 ) return false ;
        if( i == 0 ) {
            int pos = nums[i]+1;
            if(map.containsKey(pos)){
                return f(map.get(pos) , k , nums, map , dp);
            }else return false ;
        }

        boolean ans1 = false;
        boolean ans2= false ;
        boolean ans3 = false ; 

        if (dp[i][k] != null) return dp[i][k];

        if(map.containsKey(nums[i] + k)){
            ans1=f(map.get(nums[i] + k) , k , nums , map , dp);
        }

        int pos2 = nums[i] + k+1;
        if(map.containsKey(pos2)){
            ans2 = f(map.get(pos2) , k + 1 , nums, map , dp);
        }

        int pos3 = nums[i] + k -1 ;
        if(map.containsKey(pos3)){
            ans3 = f(map.get(pos3) , k - 1 , nums, map , dp);
        }

        

        return dp[i][k] = ans1 || ans2 || ans3;
        

    }
    public boolean canCross(int[] stones) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i =0 ; i < stones.length ; i++){
            map.put(stones[i] , i);
        }
        int n = stones.length;
        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];
        return f(0 , 1 , stones, map , dp);
    }
}