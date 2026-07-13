class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        Set<Integer> set = new HashSet<>(); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0] , b[0]);
            return a[1] - b[1]; 
        });

        long total = 0 ;
        int n = nums.length ;  

        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            total += val ; 
            pq.offer(new int[]{val , i});
        }
        List<Long> list = new ArrayList<>(); 

        for(int i = 0 ; i < queries.length ; i++){
            int normal = queries[i][0]; 
            int k = queries[i][1]; 
            if(!set.contains(normal)){
            set.add(normal);
            total -= nums[normal]; }

            while(!pq.isEmpty() && k != 0 ){
                int temp[] = pq.poll(); 
                int ind = temp[1]; 
                int val = temp[0] ; 
                if(!set.contains(ind)){
                    k--; 
                    total -= nums[ind]; 
                    set.add(ind);
                }
            }
            if(total <= 0) total = 0 ; 
            list.add(total); 


        }


        long ans[] = new long[list.size()]; 
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i); 
        }

        return ans; 
    }
}

// nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]