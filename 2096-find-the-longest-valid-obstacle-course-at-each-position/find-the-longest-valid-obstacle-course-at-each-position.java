class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length; 

        ArrayList<Integer> list = new ArrayList<>(); 
        int ans[] = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            int curr = nums[i]; 

            int left = 0 ; 
            int right= list.size() -1;
            int temp = list.size();  
            while(left <= right){
                int mid = left + (right - left ) / 2 ;
                if(list.get(mid) > curr){
                    temp = mid ; 
                    right = mid -1; 
                }else{
                    left = mid + 1;  
                }
            }
            if(temp == list.size()) list.add(curr);
            else list.set(temp , curr);

            ans[i] = temp+1 ;
        }

        return ans; 
    }
}