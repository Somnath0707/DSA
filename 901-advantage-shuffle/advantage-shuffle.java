class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>(); 
        int n = nums1.length ; 
        for(int i = 0 ; i < n ; i++){
            int val = nums1[i]; 
            map.put(val , map.getOrDefault(val , 0 ) + 1);
        }

        int ans[] = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            int val = nums2[i]; 

            Integer key = map.higherKey(val);
            if(key == null){
                key = map.firstKey(); 
            }
            map.put(key , map.get(key) -1 ); 
            if(map.get(key) == 0 ) map.remove(key); 

            ans[i] = key ; 
        }

        return ans; 
    }
}

// nums1 =
// [2,0,4,1,2]
// nums2 =
// [1,3,0,0,2]