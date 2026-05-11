class Solution {
    public int[] separateDigits(int[] nums) {
       List<Integer> list = new ArrayList<>();

       for(int i = 0 ; i < nums.length ; i++){
        String str = String.valueOf(nums[i]);
        for(char ch : str.toCharArray()){
            int curr = ch -'0';
            list.add(curr);
        }
       }
       int ans[] = new int[list.size()];
       for(int i = 0 ; i < list.size() ; i++){
        ans[i] = list.get(i);
       }
       return ans;
    }
}