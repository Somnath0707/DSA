class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        int left[] = new int[n]; 
        int right[] = new int[n];
        left[0] = 1 ; 
        right[n-1] = 1;

        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] >=nums[i]){
                left[i] = left[i-1] + 1;
            }
        }

        for(int i = n-2 ; i>= 0 ; i--){
            if(nums[i]<= nums[i+1]){
                right[i] = right[i+1] + 1 ; 
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = time ; i < n - time ; i++){
            if(left[i] >= time && right[i] >= time){
                list.add(i);
            }
        }
        return list;
    }
}