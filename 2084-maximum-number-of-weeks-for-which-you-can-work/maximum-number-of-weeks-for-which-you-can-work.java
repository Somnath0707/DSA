class Solution {
    public long numberOfWeeks(int[] milestones) {
        long max = 0 ; 
        long sum = 0 ; 
        int n = milestones.length; 
        for(int i = 0 ; i < n ; i++){
            int num = milestones[i]; 
            max = Math.max(max , num);
            sum+= num; 
        }

        long rest = Math.abs(sum-max);
        long ans = 0 ; 
        if(max > rest) ans = rest * 2 + 1 ; 
        if(max <= rest) ans = sum; 

        return ans; 

    }
}