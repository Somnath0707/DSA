class Solution {
    public int check(int i , int nums[] , int prefixSum[]){
        int left = 0 ; 
        int right = nums.length-1;
        int ans = 0;  
        int n = nums.length; 
        while(left <= right){
            int mid = left + (right - left ) / 2; 
            if(nums[mid] >= i){
                ans = mid ; 
                right = mid-1; 
            }else{
                left = mid+1; 
            }
        }
        if (ans == 0) return n * i;
        return prefixSum[ans - 1] + (n - ans) * i;
    }
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length ; 
        int prefixSum[] = new int[n]; 
        prefixSum[0] = arr[0]; 
        int max = arr[n-1]; 
        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i]; 
        }
        int bestDiff = Integer.MAX_VALUE; 
        int ans = 0 ; 
        for(int i = 0 ; i <= max ; i++ ){
            int temp = Math.abs(target-check(i , arr , prefixSum));

            if(temp < bestDiff){
                bestDiff = temp ; 
                ans = i ; 
                if(bestDiff == 0) return ans; 
            }

        }
        return ans; 
    }
}