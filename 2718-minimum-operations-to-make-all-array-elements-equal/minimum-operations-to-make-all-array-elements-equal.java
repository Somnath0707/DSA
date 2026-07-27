class Solution {
    public int findLess(int val , int nums[]){
        int left = 0 ; 
        int right = nums.length-1; 
        int ans = -1; 
        while(left <= right){
            int mid = left+(right-left) / 2 ; 
            if(nums[mid] < val){
                ans = mid; 
                left = mid+1; 
            }
            else {
                right = mid-1; 
            }
        }
        return ans; 
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        // We have an array nums of positive integer only 

        // we also have queries of size m for the ith query you want to make all of elements of nums equal to queries[i]

        // so the each nums and queries is 10^5 trying each would give me n^2 that is not good
        // I want greater than each query and there sum 

        // ex number that are greater than 5 and there sum number that are greater than 1 and there sum 

        // find all the elements that are greater than or less than certain value 
        // we can use binary search to do so 

        // Then we need to find the sum of value that are less than i and then greater than i 

        Arrays.sort(nums);
        int n = nums.length; 
        long[] prefixSum  = new long[n]; 

        Map<Integer, Integer> map = new HashMap<>() ; 
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1 ) ; 
        }

        List<Long> list = new ArrayList<>(); 
        // 1 3 6 8 
        // 1 4 10 18 

        // 2 6 9 3 
        // 2 3 6 9 
        // 2 5 11 20

        // we have to find a value where  the sum of value before like is <= that values * queries[i] and the later should be greater than so we know how much to add and how much to reduce 

        // 1 2 3 6 7 8 10 12  [1 , 3]
        prefixSum[0] = nums[0]; 

        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = prefixSum[i-1] + (long)nums[i];
        }
        int m = queries.length ; 
        for(int i = 0 ; i < m ; i++){
            int val = queries[i]; 

            int foundLess = findLess(val , nums); 
            if(foundLess == -1 ){
                // it means either all number are greater than val or all are lower than val ; 
                // in that case just take the answre that is pos 
                int temp = 0 ; 
                if(map.containsKey(val)) temp = map.get(val); 
                long allGreat =  1L  * (n) * val -(prefixSum[n-1] ); 
                long allSmall = 1L * (prefixSum[n-1] )- (1L *(n) * val) ;
                list.add(Math.max(allGreat, allSmall));
            }else{
                // we found a value that is lower than curr; 
                int temp = 0 ; 
                if(map.containsKey(val)) temp = map.get(val); 
                long smallSum = 1L*  (foundLess+1)* val - prefixSum[foundLess] ;
                long largeSum = 1L * (prefixSum[n-1] - prefixSum[foundLess] ) - (1L * (n-foundLess-1) * val); 

                list.add(smallSum+largeSum); 

            }
        }

        return list; 
    }
}