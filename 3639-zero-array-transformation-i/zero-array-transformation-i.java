class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length; 
        int arr[] = new int[n];

        for(int i = 0 ; i < queries.length ; i++){
            int start = queries[i][0]; 
            int end = queries[i][1]; 

            arr[start] -= 1 ; 
            if(end + 1 < n ){
                arr[end+1] += 1 ; 
            }
        }

        int ans[] = new int[n]; 
        ans[0] = arr[0] ; 

        for(int i = 1 ; i < n ; i++){
            ans[i] = ans[i-1] + arr[i]; 
        }

        for(int i = 0 ; i < n ; i++){
            // System.out.println(nums[i] + " " + ans[i]);
            nums[i] = nums[i] + ans[i]; 
            if(nums[i] < 0 ) nums[i] = 0 ; 
            
            if(nums[i] != 0 ) return false; 
        }

        return true; 
    }
}