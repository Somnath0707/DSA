class Solution {

    public boolean check(int k , int[] nums , int queries[][]){
        int n = nums.length ; 

        int [] diffArr = new int[n];

        for(int i = 0 ; i < k ;i++){
            int left = queries[i][0];
            int right = queries[i][1]; 
            int val = queries[i][2];

            diffArr[left] += val ;
            if(right + 1 < n ){
                diffArr[right + 1] -= val ; 
            }
        }
        int curr = 0 ; 
        for(int i = 0 ; i < n ; i++){
            curr += diffArr[i]; 
            if(curr < nums[i]) return false; 
        }
        return true ; 

    }   

    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0 ; 
        int right = queries.length ; 

        int ans = -1 ; 

        while(left <= right ){
            int mid = left + (right - left ) / 2 ; 

            if(check( mid , nums , queries)){
                ans = mid ; 
                right = mid -1 ; 
            }else {
                left = mid + 1 ; 
            }
        }
        return ans;
    }
}