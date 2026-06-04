class Solution {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length; 
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0 ; i <n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1);
        }
        int count= 0 ;  
        for(int i = 0 ; i < n ; i++){
            Integer next = map.higherKey(nums[i]);
            int lowest = map.firstKey();

            if(next == null){
                map.put(lowest , map.getOrDefault(lowest , 0 ) -1);
                if(map.get(lowest) == 0) map.remove(lowest);
            }
            else{
                count++;
                map.put(next , map.getOrDefault(next , 0 ) -1);
                if(map.get(next) == 0) map.remove(next);
            }
        }

        return count;
    }
}