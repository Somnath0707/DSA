class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long max = -100000000;
        for(int n : nums){
            set.add(n);
            max = Math.max(max , n);
        }

        if(max < 0) return 1 ; 

        for(int i = 1 ; i < max ; i++){
            if(!set.contains(i)){
                return i ; 
            }
        }

        return (int)max+1 ; 


    }
}