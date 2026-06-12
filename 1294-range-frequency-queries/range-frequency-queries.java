class RangeFreqQuery {
    int nums[] ; 
    Map<Integer,List<Integer>> map ;
    public RangeFreqQuery(int[] arr) {
        nums = new int[arr.length]; 
        map = new HashMap<>(); 
        for(int i =0 ; i < arr.length ; i++){
            nums[i] = arr[i];
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0 ; 

        List<Integer> list = map.get(value);
        int low = 0 ; 
        int high = list.size()-1 ; 
        int firstLeft = -1 ; 
        while(low <= high){
            int mid = low + (high - low) / 2; 

            if(list.get(mid) >= left){
                firstLeft = mid;
                high = mid -1 ; 
            }
            else {
                low = mid + 1 ; 
            }
        }
        low = 0 ; 
        high = list.size()-1 ; 
        int firstRight = -1; 
        while(low <= high){
            int mid = low + (high - low) / 2; 

            if(list.get(mid) <= right){
                firstRight = mid;
                low = mid + 1 ; 
            }
            else {
                high = mid - 1 ; 
            }
        }
        if(firstLeft == -1 || firstRight == -1 ) return 0;
        if (firstLeft <= firstRight) {
            return firstRight - firstLeft + 1;
        }
        return 0 ; 
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */