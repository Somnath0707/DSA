class Solution {
    public boolean check(int mid , int [][]prefix , int [][] suffix , int k){
        
        for(int i = 0 ; i <= mid ; i++){
            int a = prefix[i][0] + suffix[mid-i][0]; 
            int b = prefix[i][1] + suffix[mid-i][1]; 
            int c = prefix[i][2] + suffix[mid-i][2]; 
            if(a >= k && b >= k && c >= k) return true; 
        }
        return false; 
    }
    public int takeCharacters(String s, int k) {
        int n = s.length(); 
        int prefix[][] = new int[n+1][3];
        int suffix[][] = new int[n+1][3]; 

        for(int i = 1 ; i <= n ; i++){
            int val = s.charAt(i-1) -'a'; 
            prefix[i][0] = prefix[i-1][0];
            prefix[i][1] = prefix[i-1][1]; 
            prefix[i][2] = prefix[i-1][2]; 

            prefix[i][val]++; 
        }

        for(int i = 1 ; i <= n  ; i++){
            int val = s.charAt(n-i) -'a'; 
            suffix[i][0] = suffix[i-1][0];
            suffix[i][1] = suffix[i-1][1]; 
            suffix[i][2] = suffix[i-1][2]; 

            suffix[i][val]++; 
        }

        if(prefix[n][0] < k || prefix[n][1] < k || prefix[n][2] < k ) return -1 ; 

        int left = 0 ; 
        int right = n; 
        int ans = -1 ; 
        while(left <= right){
            int mid = left + (right - left) / 2; 
            if(check(mid , prefix , suffix  , k )){
                ans = mid; 
                right = mid-1 ; 
            }else {
                left = mid + 1; 
            }
        }
        return ans ; 
    }
}