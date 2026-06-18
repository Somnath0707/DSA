class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length; 
        TreeMap<Integer,Integer> map = new TreeMap<>(); 

        for(int i = n/2 ; i < n ; i++){
            int num = nums[i]; 
            map.put(num , map.getOrDefault(num , 0 ) + 1 ) ; 
        }
        int count = 0 ; 
        for(int i = 0 ; i < n/2 ; i++){
            Integer key = map.ceilingKey(2 * nums[i]);
            if(key != null){
                map.put(key , map.get(key) - 1 ) ; 
                if(map.get(key) == 0) map.remove(key);
                count+=2; 
            }
        }
        return count ; 
    }
}