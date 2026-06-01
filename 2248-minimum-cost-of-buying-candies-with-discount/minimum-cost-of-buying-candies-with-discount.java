class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length ;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ;i++){
            list.add(nums[i]);
        }

        Collections.sort(list , (a,b) -> b-a);
        int count = 0 ; 
        int cost = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(count == 2){
                count = 0 ; 
                continue;
            }
            else {
                cost += list.get(i);
                count++;
            }
        }
        return cost; 
    }
}