class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        // 10 
        // 0 2 4 1 2 6 1 1 3
        // max = 7

        // 0 2 4/0

        // 0 2 4 1 2 6 3 2 1 3

        // 
        int arr[] = new int[n]; 
        Arrays.fill(arr , Integer.MAX_VALUE); 
        arr[0] = 0 ; 

        for(int num[] : restrictions){
            int idx = num[0]; 
            int val = num[1]; 
            arr[idx] = val; 
        }

        for(int i = 1 ; i < n ; i++){
            arr[i] = Math.min(arr[i] , arr[i-1] + diff[i-1]);
        }
        for(int i = n-2 ; i >= 0; i--){
            arr[i] = Math.min(arr[i] , arr[i+1] + diff[i]);
        }

        int ans = 0 ; 

        for(int num : arr){
            ans = Math.max(ans , num); 
        }
        return ans; 
    }
}