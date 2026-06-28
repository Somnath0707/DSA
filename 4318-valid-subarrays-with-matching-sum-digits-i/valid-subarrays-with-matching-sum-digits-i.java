class Solution {
    public int solve(long num){
        while(num >= 10 ){
            num /=10;
        }

        return(int) num; 
    }
    public int countValidSubarrays(int[] nums, int x) {
        int ans = 0 ; 
        int n = nums.length; 
        for(int i = 0 ; i < n ; i++){
            long sum = 0 ; 
            for(int j = i ; j < n ;j ++){
                sum += nums[j] ; 
                int lastDigit  =(int)(sum % 10) ; 
                int firstDigit = solve(sum);

                if(firstDigit == x && lastDigit == x ) ans++; 
            }
        }
        return ans ; 
    }
}