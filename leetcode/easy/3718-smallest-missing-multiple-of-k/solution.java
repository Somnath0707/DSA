class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(); 
        for(int num : nums){
            set.add(num); 
        }
        int ans = 0 ; 
        for(int i = 1 ; i <= 110 ; i++ ){
            if(!set.contains(k*i)){
                ans = k*i; 
                // System.out.println("Inside");
                System.out.println(k*i); 
                break; 
            }
            // System.out.println(k*i); 
        }
        return ans; 
    }
}