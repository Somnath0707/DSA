class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int arr[] = new int[n]; 

        for(int i = 0; i < bookings.length ; i++){
            int first = bookings[i][0]; 
            int last = bookings[i][1]; 
            int val = bookings[i][2]; 

            arr[first-1] += val;

            if(last < n){
                arr[last] -= val;
            }
        }

        int ans[] = new int[n]; 
        ans[0] = arr[0]; 
        for(int i = 1 ; i < n ; i++){
            ans[i] = ans[i-1] + arr[i]; 
        }

        return ans;
    }
}