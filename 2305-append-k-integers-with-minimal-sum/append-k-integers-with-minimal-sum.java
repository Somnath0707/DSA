class Solution {
    public long f(int start , int k){
        long first = (long)start;
        long last = first + k -1 ; 
        long n = last - first+1; 
        long sum = (first + last) * n / 2;

      
        return sum ; 


    }
    public long minimalKSum(int[] nums, int k) {
        long sum = 0 ; 
        int n = nums.length; 

        Arrays.sort(nums);
        int tempK = Math.min(k , nums[0]-1);
        k -= tempK;
        System.out.println(k);
        sum += f(0 , tempK+1);
        for(int i = 1 ; i < n ; i++){
            if(k == 0 ) break ;
            System.out.println(k);
            if(nums[i-1] == nums[i] -1  || nums[i] == nums[i-1]) continue; 
            int temp = Math.min(k , nums[i]-nums[i-1]-1);
            k -= temp; 
            sum += f(nums[i-1]+1 , temp);
        }

        if(k > 0){
            sum+= f(nums[n-1]+1 , k);
            System.out.println(k);
        }

        return sum; 
    }
}