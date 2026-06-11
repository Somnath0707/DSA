class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>(); 
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            StringBuilder key = new StringBuilder();
            for(int j = i ; j < n ; j++){
                // System.out.println("The value that is currenty checking : " + nums[j]);
                if(nums[j] % p == 0 ){
                    // System.out.println(nums[j] + "%" + p );
                    count++; 
                }
                if(count <= k ){
                    String temp = nums[j] + "#";
                    key.append(temp); 
                    // System.out.println(key.toString());
                    set.add(key.toString());
                }else{
                    break; 
                }
            }
        }
        return set.size() ; 
    }
}