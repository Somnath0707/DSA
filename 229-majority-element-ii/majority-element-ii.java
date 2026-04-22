class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length ; 
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1 ) ;
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/3){
                list.add(entry.getKey());
            }
        }
        return list ;
    }
}