class Solution {
    public int bs(int suffix[] , int req , int left  ){
        // int left = 0 ; 
        int right = suffix.length-1; 
        while(left <= right){
            int mid = left + (right-left) /2 ; 

            if(suffix[mid] == req){
                return suffix.length - 1 - mid; 
            }
            else if(suffix[mid] > req){
                left = mid+1 ; 
            }
            else {
                right = mid-1; 
            }
        }
        return 10000000;
    }
    public int minOperations(int[] nums, int x) {
        // 1 1 4 2 3 
        // 1 2 6 8 11
        // 11 10 9 5 3

        // is there any 5 here yes 5 from right 2 ; 
        // 1 is there any 4 no 
        // 2 is there any 3 
        // take 6 so no break 
        // 5 is there any 5 yesh ther is 
        // take 3 is thery any 2 yes


        // 3 2 20 1 1 3
        // 3 5 25 26 27 30
        // 30 27 25 5 4 3
        // then use binary search 
        // try from both sides 
        // first 10 is there any 10 here from left and riht no 
        // 3 is there any 7 here no 
        // 5 is there nay 5 from both sides left and right yes 2 + 3  = 5 
        int n = nums.length; 
        int prefix[] = new int[n+1]; 
        int suffix[] = new int[n+1];
        prefix[0] = 0 ; 
        suffix[n] = 0 ; 
      
        for(int i = 1; i <= n ; i++){
            prefix[i] = prefix[i-1] + nums[i-1]; 
        }

        for(int i= n-1 ; i>= 0 ; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }
          int ans = bs(suffix , x , 0); 

        for(int i = 1 ; i <= n ; i++){
            int val = prefix[i]; 
            int req = x - prefix[i];
            if(req < 0) break; 
            ans = Math.min(ans , (i)+ bs(suffix , req , i));

        }

        if(ans == 10000000) return -1; 
        return ans; 
        
    }
}