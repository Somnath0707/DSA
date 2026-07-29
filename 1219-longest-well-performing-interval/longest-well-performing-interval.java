class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length; 
        int prefixSum[] = new int[n+1]; 

        prefixSum[0] = 0 ; 
        int ind = 0 ; 
        for(int i = 1 ; i <= n ;i++){
            prefixSum[i] = prefixSum[i-1] + (hours[i-1] > 8 ? 1 : -1);
        }

        Stack<Integer> st = new Stack(); 

        for(int i = 0 ; i <= n ; i++){
            if(st.isEmpty() || prefixSum[st.peek()] > prefixSum[i]){
                st.push(i); 
            }
        }

        int ans = 0 ;
        for(int i = n ; i >= 0 ; i--){
            while(!st.isEmpty() && prefixSum[st.peek()] < prefixSum[i]){
                ans = Math.max( ans , i - st.peek());
                st.pop(); 
            }
        }

        return ans; 
    }
}