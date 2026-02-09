class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; 
        Map<Integer , Integer> map = new HashMap<>();
        int ans = 0; 

        for(int right = 0 ; right < nums.length ; right++){
            int rhs = nums[right];
            map.put(rhs , map.getOrDefault(rhs , 0 ) + 1);
            while(map.getOrDefault(0, 0)>k){
                int lf = nums[left];
                map.put(lf , map.get(lf) - 1);
                if(map.get(lf) == 0){
                    map.remove(lf);
                }
                left++;

            }
            ans = Math.max(ans , right - left + 1);
        }
        return ans ;
    }
}