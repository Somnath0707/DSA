class Solution {
    public boolean[] canEat(int[] nums, int[][] queries) {
        // type day and daily 

        // i have to eat total atleast 10 candies and at most 16 till day 2
        // daily limit is inf here and days we have to surive till is day 13 
        // if the total candies till that day is less than day we cant return false; 
        // ex suppose i have to surive day 12 but i have only 10 canides till that even if i eat one i will not surive 
        // what if we have excess how much excess can we have 

        // if i wnat what eat at least 20 and at most 28 in 2 days while daily i can just eat 4 is it possilbe no why maths? 
        // -> 4 * 2 max we can reach is 8 min we need is 4 can we reach 20 or 28 no 

        // if we can eat 2 candies per day for 3 days and we have to eat atmost 7 atleast 1 

        // is it possible max = 2*3 = 6 atmost at least 1 * 3 so 3 to 6 we can eat so it is possible as it fall in the range 7 to 1 we can eat atleast one right 


        // [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
        // 0 1  2 3  4
        // 5 7 13 17 18 -> 
        // first is type 3 at day 1+1 = 2 at most we can eat is 2 so we have 2* 3 = 6 max and min is 1 * 3 = 3 
        // we want in range is min 14 max 17 is it possible for us to here so false; 
        // max = 11* 3 = 33 min = 11 * 1 = 11 for type 4 max is 18 min is 18 yes 

        // for 11 * 100 = 1100 min is 11* 1 for type 3 14 is miin and 17 is max so we pass 

        // 100 * 31 = 3100 100 * 1 = 100 for type 4 min is 18 max is 18 but here 100 and 3100 both are greater so false ;  easy question tbh    
        int n = nums.length; 

        long prefixSum[] = new long[n+1]; 
        prefixSum[0] = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            prefixSum[i]= nums[i-1] + prefixSum[i-1]; 
        }
        int m = queries.length;
        boolean ans[] = new boolean[m]; 
         
        for(int i = 0 ; i < m ; i++){
            int curr[] = queries[i]; 
            int type = curr[0]; 
            int days = curr[1]+1; 
            int daily = curr[2]; 
            long minCap = 1L * days; 
            long maxCap = 1L * daily * days; 

            long min = prefixSum[type]+1; 
            long max = prefixSum[type+1];
            if(maxCap >= min && minCap <= max){
                ans[i] = true; 
            }
            else if(max >= minCap && max <= maxCap){
                ans[i] = true; 
            }else{
                ans[i] = false; 
            }
        }

        return ans; 

    }
}