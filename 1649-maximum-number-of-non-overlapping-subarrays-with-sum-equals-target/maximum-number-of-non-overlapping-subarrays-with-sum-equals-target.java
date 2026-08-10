class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        // 1 2 3 4 5 6 
        // -1 2 7 8 12 14 5
        Map<Integer,Integer> map =new HashMap<>();
        int n = nums.length;
        int prefix[] = new int[n+1]; 
        prefix[0] = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        map.put(0 , 0);
        int ans = 0 ; 
        int prev = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            int find = prefix[i] - target; 
            if(map.containsKey(find)){
                if(map.get(find) >= prev ) {
                    prev = i; 
                    ans++; 
                }
            }
            map.put(prefix[i] , i);
        }

        return ans; 

    }
}