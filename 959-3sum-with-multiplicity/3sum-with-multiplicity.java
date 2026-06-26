class Solution {
    int MOD = 1000000007;
    public int threeSumMulti(int[] arr, int target) {
        // 1. Array instead of Map. Size 101 because arr[i] is 0 to 100
        int[] count = new int[101]; 
        for(int n : arr){
            count[n]++; 
        }
        
        int n = arr.length; 
        int ans = 0; 
        
        for(int i = 0; i < n - 2; i++){
            int num = arr[i]; 
            count[num]--; // Remove arr[i] from available pool
            
            // 2. Cloning a 101-length primitive array takes literal nanoseconds
            int[] temp = count.clone(); 
            
            for(int j = i + 1; j < n; j++){
                int find = target - (num + arr[j]); 
                
                temp[arr[j]]--; // Remove arr[j] before checking
                
                // 3. Since 'find' could be up to 300, just make sure it's safely between 0 and 100
                if(find >= 0 && find <= 100){
                    ans = (ans + temp[find]) % MOD;
                }
            }
        }

        return ans; 
    }
}