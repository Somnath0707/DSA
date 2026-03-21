class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
       // put all the k * nums2 in the hashtable then check go through nums1 
       // if hashtable contains the multiple fo the nums[1] then we increase the count by 1 
       // we can take that till the max element in the map 
       // ex : 1,3,4] here we will take 1 multiple till the 4 if there are present then increase the count by 1 ; 
        Map<Integer , Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i< nums2.length ; i++){
            map.put(nums2[i] * k , map.getOrDefault(nums2[i]*k  , 0 ) + 1 );
        }
        long count = 0 ;  
        for(int i = 0 ; i< nums1.length ; i++){
            for(int j = 1 ; j * j <= nums1[i] ; j++){
                if(nums1[i] % j == 0){
                    int factor1 = j;
                    int factor2 = nums1[i] / j;

                    if(map.containsKey(factor1)){
                        count += map.get(factor1);
                    }
                    if(factor1 != factor2 && map.containsKey(factor2)){
                        count += map.get(factor2);
                    }
                }
            }
        }
        return count;
    
    }
}