class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int count = 0 ; 
        int n = nums.length; 
        for(int i =0 ; i < n ; i++){
            if(nums[i] < pivot) listA.add(nums[i]);
            else if(nums[i] > pivot ) listB.add(nums[i]);
            else count++;
        }

        int len = listA.size() + count + listB.size();
        int ans[] = new int[len]; 
        int ind = 0 ; 
        for(int i = 0 ; i< listA.size() ; i++){
            ans[ind++] = listA.get(i);
        }
        while(count != 0){
            ans[ind++] = pivot;
            count--; 
        }

        for(int i = 0 ; i < listB.size() ; i++){
            ans[ind++] = listB.get(i);
        }
        return ans; 
    }
}