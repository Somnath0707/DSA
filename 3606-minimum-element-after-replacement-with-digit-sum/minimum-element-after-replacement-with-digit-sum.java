class Solution {
    public int minElement(int[] nums) {
        int n = nums.length ; 
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int num = 0 ; 
            String s = String.valueOf(nums[i]);
            int left  = 0 ; 
            int right = s.length()-1;
            while(left <= right){
                if(left==right){
                    num+=s.charAt(left)-'0';
                    left++;
                    continue;
                }
                int lSide = s.charAt(left)-'0';
                int rSide = s.charAt(right) -'0';
                // System.out.println(lSide + " " + rSide);
                num += lSide + rSide; 
                left++;
                right--;
            }
            ans = Math.min(num , ans);
        }
        return ans; 
    }
}