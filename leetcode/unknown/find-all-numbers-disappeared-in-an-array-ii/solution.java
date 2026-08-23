class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>(); 
        int n = nums.length ; 
        int prev = lower ; 
        for(int i = 0 ; i < n; i++){
            int curr = nums[i]; 
            if(curr > prev){
                List<Integer> list = new ArrayList<>(); 
                list.add(prev);
                list.add(Math.min(curr-1 , upper)); 
                prev = curr +1; 
                ans.add(list); 
                if(prev > upper) break;
            }
            else if(curr > upper){
                List<Integer> list = new ArrayList<>(); 
                list.add(Math.min(prev , upper)); 
                list.add(upper); 
                prev = curr+1; 
                ans.add(list); 
                if(prev > upper) break; 
            }else{
                prev = Math.max(curr+1 , lower); 
                
                if(prev > upper) break; 
            }
            
        }

        if(prev <= upper){
            List<Integer> list = new ArrayList<>(); 
            list.add(prev); 
            list.add(upper); 
            ans.add(list); 
        }

        return ans; 
    }
}