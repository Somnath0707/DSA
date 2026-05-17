class Solution {
    public boolean canReach(int[] nums, int start) {
        Queue<int[]> q = new LinkedList<>();
        int n = nums.length;
        q.offer(new int[]{nums[start] , start});
        boolean[] vis = new boolean[n];
        vis[start] = true; 

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int val = curr[0];
            int i = curr[1];
            int nextInd = i + val ;
            int prevInd = i - val;

            if(nums[i] == 0 ) return true; 
            if(nextInd < n  && !vis[nextInd]){
                q.offer(new int[]{nums[nextInd] , nextInd});
                vis[nextInd] = true;
            }
            if(prevInd >= 0 && !vis[prevInd]){
                q.offer(new int[]{nums[prevInd] , prevInd});
                vis[prevInd] = true;
            }
        }
        return false;
    }
}