class Solution {
    // find the left 
    public int bs(int nums[][] , int left , int right){
        int candle = nums[left][1]+1; 
        int ans = -1; 
        while(left <= right){
            int mid = left + (right -left ) / 2; 
            if(nums[mid][1] >= candle){
                if(nums[mid][1] == candle){
                    ans = mid-1; 
                }
                right = mid-1; 
            }else{
                left = mid+1; 
            }
        }
        return ans; 
    }
    public int rightBs(int nums[][] , int left , int right){
        int candle = nums[right+1][1]; 
        int ans = -1; 
        while(left <= right){
            int mid = left + (right - left)/2; 
            if(nums[mid][1] >=candle){
                if(nums[mid][1] == candle) ans = mid-1; 
                right = mid-1; 
            }
            else {
                left = mid+1; 
            }
        }
        return ans;
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // we can take prefix sum and find candle 
        // for we can take candle lie if left is not candle find the first occ of th canle to the rigth which is less the right max 
        int n = s.length(); 
        // we will store the sum of cnadle and the plate along the way 
        int prefix[][] = new int[n+1][2]; 
        prefix[0][0] = 0 ; 
        prefix[0][1] = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int candle = prefix[i][1]; 
            char ch = s.charAt(i); 
            // if we have not seen any plate we dont need there candle 
            if(candle <= 0 && ch == '*'){
                continue; 
            }
            
            // if we have atleast seen one plate  we can add candle
             if(ch == '*'){
                prefix[i+1][0] = 1 + prefix[i][0] ; 
                prefix[i+1][1] = prefix[i][1]; 
            }
            // we add plate 
            else{
                prefix[i+1][0] = prefix[i][0];
                prefix[i+1][1] = 1 + prefix[i][1];
            }
        }

        int ans[] = new int[queries.length]; 

        for(int i = 0 ; i < queries.length ; i++){
            int left = queries[i][0]; 
            int right = queries[i][1]; 
            
            // if less than one plate 
            if(prefix[right+1][1] < 2){
                ans[i] = 0 ; 
                continue;
            }

            
            int newLeft = left; 
            int newRight = right; 
            if(s.charAt(left) != '|'){
                newLeft = bs(prefix , left , right+1);
            }
            if(s.charAt(right) != '|'){
                newRight = rightBs(prefix , left , right);
            }

            if(prefix[right + 1][1] - prefix[left][1] < 2){
                ans[i] = 0 ; 
                continue; 
            }

            ans[i] = prefix[newRight+1][0] - prefix[newLeft][0];
        }  

        return ans; 
    }
}