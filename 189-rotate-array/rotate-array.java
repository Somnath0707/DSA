class Solution {
    public void rotate(int[] nums, int k) {
        
        List<Integer> list = new ArrayList <>();
        int n = nums.length;

        k = k % n; 

        for(int i = n-k; i < n ; i++){
            list.add(nums[i]);
        }
        for(int j = 0 ; j < n -k; j++){
            list.add(nums[j]);
        }

        int[] ans = new int[n];

        // copy back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
        return ; 
    }
}