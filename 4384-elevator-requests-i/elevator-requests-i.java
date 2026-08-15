class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0 ; 
        int prev = 0 ; 
        for(int i = 0 ; i < requests.length ; i++){
            int curr = requests[i]; 
            ans += Math.abs(curr-prev); 
            prev = curr;
        }

        return ans; 
    }
}