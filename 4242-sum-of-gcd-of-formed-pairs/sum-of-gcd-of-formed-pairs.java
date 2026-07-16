class Solution {
    public int gcd(int a , int b){
        while(b != 0 ){
            int temp = b ; 
            b = a % b; 
            a = temp ; 
        }
        return a; 
    }
    public long gcdSum(int[] nums) {
        int n = nums.length ; 
        int currMax = 0 ; 
        int ans[] = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            int num = nums[i]; 
            currMax = Math.max(currMax , num);

            ans[i] = gcd(currMax , num);
        }

        Arrays.sort(ans);
        long sum = 0 ; 

        int left = 0 ; 
        int right = n-1; 
        while(left < right){
            sum += gcd(ans[left] , ans[right]);
            left++;
            right--; 
        }

        return sum ; 


    }
}