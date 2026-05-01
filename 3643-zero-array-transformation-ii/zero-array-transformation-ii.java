class Solution {

    public boolean check(int k , int nums[] , int queries[][]){
        int n = nums.length ; 

        int diffArr[] = new int[nums.length];


        // Check for the first few queries 
        for(int i = 0 ; i < k ; i++){
            int curr[] = queries[i];
            int left = curr[0];
            int right = curr[1];
            int val = curr[2];

            diffArr[left] += val;
            if(right + 1 < n ){
                diffArr[right+1] -= val;
            }
        }

        int curr = 0; 
        for(int i =0 ; i < n ; i++){
            curr += diffArr[i];

            if(curr < nums[i]){
                return false ; 
            }
        }
        return true; 
        

    }
    public int minZeroArray(int[] nums, int[][] queries) {

        int left = 0 ; 
        int right = queries.length ; 

        int ans = - 1; 

        while(left <= right ){
            int mid = left + (right - left) / 2; 

            if(check(mid , nums , queries)){
                ans = mid ; 
                right = mid -1 ; 
            }else {
                left = mid + 1 ; 
            }
        }

        return ans; 

    }
}