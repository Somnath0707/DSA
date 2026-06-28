class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 1; 
        int n = arr.length ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[0] != 1 ) {
                arr[0] = 1;
            } 
            else if(i > 0 && arr[i]-arr[i-1] > 1){
                arr[i] = arr[i-1]+1; 
            }
            max = Math.max(arr[i] , max);

        }

        return max;
    }
}