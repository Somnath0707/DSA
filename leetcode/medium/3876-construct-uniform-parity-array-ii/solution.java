class Solution {
    public boolean uniformArray(int[] nums) {
        TreeMap<Integer,Integer> odd = new TreeMap<>();
        int n = nums.length; 
        for(int i = 0 ; i < nums.length ; i++){
            int val = nums[i]; 
            if(val % 2 == 0){
                continue; 
            }else{
                odd.put(val , i);
            }
        }
        boolean foundAns = true; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            if(val % 2 == 0) continue; 
            else{
                Integer key = odd.lowerKey(val);
                if(key == null){
                    foundAns = false; 
                    break; 
                }
            }
        }

        if(foundAns) return foundAns; 
        boolean foundAnsTwo = true; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            if(val % 2 != 0) continue; 
            else{
                Integer key = odd.lowerKey(val);
                if(key == null){
                    foundAnsTwo = false; 
                    break; 
                }
            }
        }
        
        return foundAns || foundAnsTwo; 
    }
}