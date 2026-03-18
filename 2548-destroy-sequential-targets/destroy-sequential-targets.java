class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer , Integer > map = new HashMap<>();
        Map<Integer , Integer > min = new HashMap<>();

        for(int i =0 ; i< nums.length ;i++){
            int a = nums[i] % space ;
            map.put(a , map.getOrDefault(a , 0) + 1 );
            if(min.containsKey(a)){
                min.put(a , Math.min(min.get(a) , nums[i]));
            }
            else {
                min.put(a , nums[i]);
            }
        }

        int maxFreq = Integer.MIN_VALUE;
        for (int val : map.values()) {
            maxFreq = Math.max(maxFreq, val);
        }

        // step 2: tie-break using min value
        int ans = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                ans = Math.min(ans, min.get(key));
            }
        }

        return ans;
    }
}