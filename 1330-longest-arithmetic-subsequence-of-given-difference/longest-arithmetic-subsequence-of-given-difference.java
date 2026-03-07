class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer , Integer> dp = new HashMap<>();

        int ans = 0; 

        for(int n : arr){
            int prev = n - diff;

            int len = dp.getOrDefault(prev , 0) + 1 ;

            dp.put(n, len );

            ans = Math.max(ans , len );
        }

        return ans ;
    }
}