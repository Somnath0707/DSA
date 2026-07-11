class FindSumPairs {
    Map<Integer,Integer> map = new HashMap<>();  ; 
    Map<Integer ,Integer> map2 = new HashMap<>(); ;
    int nums1[]; 
    int nums2[]; 
    public FindSumPairs(int[] nums3, int[] nums4) {
        // nums1 = Arrays.copyOf(nums3);
      
        nums2 = nums4.clone();

        for(int i = 0 ; i < nums3.length ;i++){
            int val = nums3[i]; 
            map.put(val , map.getOrDefault(val , 0 ) + 1 ); 
        }

        for(int i = 0 ; i < nums2.length ; i++){
            int val = nums2[i]; 
            map2.put(val , map2.getOrDefault(val , 0 ) + 1 ) ; 
        }

    }
    
    public void add(int index, int val) {
        int temp =  nums2[index]; 
        map2.put(temp , map2.get(temp) -1 );
        if(map2.get(temp) == 0  ) map2.remove(temp);
        nums2[index] += val ; 
        map2.put(nums2[index] , map2.getOrDefault(nums2[index] , 0 ) + 1 ) ; 
        // return ; 
    }
    
    public int count(int tot) {
        int ans = 0 ; 
        for(Map.Entry<Integer ,Integer> entry : map.entrySet()){
            int find = tot - entry.getKey(); 
            if(map2.containsKey(find)){
                ans += entry.getValue() * map2.get(find);
            }
        }
        return ans; 
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */