class RollingHash{
    long pow[] ; 
    long hash[]; 
    long base = 6767; 
    long MOD = 1000000007; 

    RollingHash(int nums[]){
        int n = nums.length; 

        pow = new long[n+1];
        hash = new long[n]; 

        pow[0] = 1; 
        for(int i = 1 ; i <= n ; i++){
            pow[i] = (pow[i-1] * base) % MOD; 
        }

        hash[0] = nums[0]+3; 
        for(int i = 1 ; i < n ; i++){
            hash[i] = (hash[i-1] * base + (nums[i] + 3) ) % MOD ; 
        }
    }

    long getHash(int l , int r){
        if( l == 0 ) return hash[r]; 

        long ans = (hash[r] - (hash[l - 1] * pow[r - l + 1]) % MOD + MOD) % MOD;

        if(ans < 0 ) ans += MOD ; 
        return ans ; 
    }
}
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length; 

        int arr[] = new int[n-1]; 
        

        for(int i = 0 ; i < n-1 ; i++){
            if(nums[i] > nums[i+1]){
                arr[i] = -1; 
            }
            else if(nums[i] == nums[i+1]){
                arr[i] = 0 ; 
            }else arr[i] = 1; 
            // System.out.print(arr[i] + " " );
        }
        RollingHash re = new RollingHash(arr); 
        RollingHash rh = new RollingHash(pattern); 
        int count = 0 ; 
        int size = pattern.length; 
        for(int i = 0 ; i < arr.length-size+1 ; i++){
            int left = i ; 
            int right = i + size-1; 
            if(re.getHash(left , right) == rh.getHash(0 , pattern.length-1)){
                // System.out.println(re.getHash(left , right));
                // System.out.println(rh.getHash(0 , pattern.length-1));
                count++; 
            }
        }

        return count; 
    }
}