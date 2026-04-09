class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int sum = 0 ; 
        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0) + 1 ) ; 
            sum += n ; 
        }
        int max = -1001;
        for(int i = 0 ; i < nums.length ; i++){
            int check = sum - (2*nums[i]);
            if(map.containsKey(check)){
                if(check != nums[i] || map.get(check) >= 2)
                max = Math.max(max , check);
            }
        }
        return max ; 
    }
}

