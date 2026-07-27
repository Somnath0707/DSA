class Solution {
    public boolean check(String s , String p , int []nums , int mid){
         
        Set<Integer> set = new HashSet(); 
        for(int i = 0 ; i < mid ; i++){
            set.add(nums[i]);
        }
        int i = 0 ; 
        int j = 0 ; 
        while(i < s.length() && j < p.length()){
            if(set.contains(i)){
                i++; 
            }
            else if(s.charAt(i) == p.charAt(j)){
                i++; 
                j++; 
            }
            else {
                i++; 
            }
        }
        if(j == p.length()){
            return true; 
        }
        return false; 
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0 ; 
        int right = removable.length; 
        int ans = 0 ; 
        while(left <= right){
            int mid = left + (right - left ) /2 ; 
            if(check(s , p , removable , mid)){
                ans = mid ; 
                left = mid+1; 
            }
            else {
                right = mid-1; 
            }
        }

        return ans; 
    }
}