class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int ans2[] = new int[n]; 
        ans[0] = 0 ;
        ans2[n-1] = 0 ; 
        // 0 ,10 , 14 , 22
        for(int i = 1 ; i < n ;i++){
            ans[i] = ans[i-1] + nums[i-1];
        }
        System.out.println();

        for(int i = n-2 ; i >= 0 ; i--){
            ans2[i] = ans2[i+1] + nums[i+1];
        }

        int res[] = new int[n]; 

        for(int i = 0 ; i <n ; i++){
            res[i] = Math.abs(ans[i] - ans2[i]);
        }

        return res;
    }
}