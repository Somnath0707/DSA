class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        List<Integer> list2 = new ArrayList<>(); 

        int prev1 = -1; 
        int prev2 = -1;
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++){
            if(i > 1){
                if(prev1 > prev2){
                    list.add(nums[i]);
                    prev1 = nums[i]; 
                }else{
                    list2.add(nums[i]);
                    prev2 = nums[i]; 
                }
            }
            else if(i == 0){
                list.add(nums[i]); 
                prev1 = nums[i]; 
            }
            else{
                list2.add(nums[i]); 
                prev2 = nums[i]; 
            }
        }

        int ans[] = new int[n]; 
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i); 
        }
        int ind = list.size(); 
        for(int i = 0 ; i < list2.size() ; i++){
            ans[ind++] = list2.get(i); 
        }
        return ans; 
    }
}