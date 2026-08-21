class Solution {
    public boolean f(int i , int mask , int nums[][]){
        int n = nums.length; 
        if(i == nums.length ) return true; 

        if(((mask >> i) & 1) == 1){
            for(int ind = 0 ; ind < n ; ind++){
                if(nums[i][ind] == 2 ) continue; 
                int curr = (mask >>ind ) & 1 ; 
                if(nums[i][ind] != curr) return false; 
            }
        }// the current is telling truth

        // suppose its bad then doesnot matter what he says 
        return f(i+1 , mask , nums); 
        
    }
    public int maximumGood(int[][] nums) {
        // we have good and bad people 

        //good always tell true bad person may lie or may tell the truth 


        // we have statements arry of n*n made by n people about each other 

        // 0 tell that person made by person i that person j is bad 
        // 1 tells the i that j is good
        // 2 no state ment is made 
        // no person make a statement about themself 

        // return max number of people who can be good based on the state ment made by the n people 

        // [[2,1,2],[1,2,2],[2,0,2]] here the first 2 1 2 means 
        // 0 does not say about it self 0 says person 1 is good and no opinon on 2 
        // 1 2 2  now that person 1 tells that person 1 is bad person and no opinoin aobut other 
        // 2 0 2 the person says that the person 1 is bad 

        // 0 -> 1 is good , 1 -> 0 is good , 2 -> 1 is bad

        // suppose that person 1 is saying mean means all the statement made by him are correct so we can mark the good and bad as per him 
        // now that all the people connected to him are either good or bad 

        // so suppose we take 1 we can mask the values as good or bad that would help use further if next we get to the next person if not marked so we can easily try that preson that is good he may be telling true or maybe not 
        

        // how do i mask like to
        int ans = 0 ;  
        int n = nums.length ; 
        for (int mask = 0; mask < (1 << n); mask++) {
            // mask = one possible assignment

            if(f(0 , mask, nums)) ans = Math.max(ans , Integer.bitCount(mask)); 
        }
        return ans; 
    }
}