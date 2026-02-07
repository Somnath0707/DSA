class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer , Integer> left = new HashMap<>();
        Map<Integer , Integer> right = new HashMap<>();
        int mod = (int)1e9+7 ;

        for(int n : nums){
            right.put(n , right.getOrDefault(n , 0) + 1);
        }

        long ans = 0; 

        for(int i = 0 ; i < nums.length ; i++){
            int x = nums[i];
            
            int cnt = right.get(x) - 1;
            if(cnt == 0) right.remove(x);
            else right.put(x , cnt);
            int want = x * 2; 

            long L = left.getOrDefault(want , 0);
            long R = right.getOrDefault(want , 0);

            ans = (ans + (L * R) % mod)% mod;

            left.put(x , left.getOrDefault(x , 0) + 1);
        }

        return (int) ans ;
    }
}