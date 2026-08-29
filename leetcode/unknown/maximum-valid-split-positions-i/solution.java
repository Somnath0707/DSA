class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int maxValidSplits(int[] nums) {
        int n = nums.length; 
        int prefix[] = new int[n]; 
        int suffix[] = new int[n]; 

        prefix[0] = nums[0]; 
        for(int i = 1 ; i < n ; i++){
            prefix[i] = gcd(prefix[i-1] , nums[i]);
        }
        suffix[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = gcd(suffix[i+1] , nums[i]);
        }

        int ans = 0 ; 

        for(int i = 0 ; i < n-1 ; i++){
            if(prefix[i] == suffix[i+1]) ans++; 
        }

        for(int i = 0 ; i < n ; i++){
            int cur = 0;
            int suf[] = new int[n];
            int g = 0;
            for(int j = n - 1 ; j >= 0 ; j--){
                if(j == i) continue;
                g = gcd(g, nums[j]);
                suf[j] = g;
            }

            int lhs = 0; 
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue; 

                lhs = gcd(lhs, nums[j]);
                count++;
                if(count == n - 1) break;

                int next = (j + 1 == i) ? j + 2 : j + 1;
                int rhs = suf[next]; 
                if(lhs == rhs) cur++; 
            }
            ans = Math.max(ans, cur);
        }
        return ans; 
    }
}