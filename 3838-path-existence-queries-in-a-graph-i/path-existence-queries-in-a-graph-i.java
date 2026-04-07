class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int group[] = new int[n];
        int currGroup = 0 ; 
        for(int i = 1 ; i < n ; i++){

            if(nums[i] - nums[i-1] > maxDiff){
                currGroup ++; 
            }
            group[i] = currGroup;
        }

        boolean[] res = new boolean[queries.length];
        int indx = 0 ; 

        for(int[] curr : queries){
            int i = curr[0];
            int j = curr[1]; 

            if(group[i] == group[j]) {
                res[indx] = true;
            }
            indx++;
            
        }
        return res;
    }
}