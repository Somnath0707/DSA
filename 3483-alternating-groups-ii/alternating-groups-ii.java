class Solution {
    public int numberOfAlternatingGroups(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        for(int i = 0 ; i < k-1 ; i++){
            list.add(nums[i]);
        }
        // 0 0 0 1 0 1
        int n = nums.length; 
        int i = 0 ; 
        int j = 1 ; 
        int ans = 0 ; 
        int prev = nums[i];
        int size = list.size();
        while(j < size){
            boolean alter = false;
            while(j-i+1 <= k && j < size){
                if(prev != list.get(j)){
                    prev = list.get(j);
                    j++;
                    alter = true; 
                }
                else{ 
                    alter = false;
                    break;
                }
            }
            if(alter == true && j-i == k){
                ans++;
                prev = list.get(j-1);
            }
            i++;

            if(j< i+1){
                j++;
            }

        }
        return ans; 
    }
}

//[0,1,0,0,0 , 0 ,1]  