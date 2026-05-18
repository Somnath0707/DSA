class Solution {
    public int minJumps(int[] nums) {
        // at each step we can either take the curr or prev or the next and if takend mark them as vis 
        // use bfs and hashtable 
        int n = nums.length;
        // How can we store the index of the dups too in the hash map 
        // like 23 there should be 23:1 , 23: 5 how do we do it 
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0  ; i < nums.length ; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            }
            else{
                List<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(num , index);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        boolean vis[] = new boolean[nums.length];
        // number and index and jumps
        q.offer(new int[]{ nums[0] , 0 , 0 });
        List<Integer> temp = map.get(nums[0]);
        temp.remove(Integer.valueOf(0));
        map.put(nums[0] , temp);
        // mark as vis 
        vis[0] = true;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int val = curr[0];
            int ind = curr[1];
            int jump = curr[2];
            System.out.println(jump + " " + ind);

            if(ind == n - 1) return jump ;
            // 3 cases 
            if(ind+1 < n && !vis[ind+1]){
                q.offer(new int[]{nums[ind+1] , ind+1 , jump+1});
                vis[ind+1] = true;
            }
            if(ind-1 >= 0 && !vis[ind-1]){
                q.offer(new int[]{nums[ind-1] , ind-1 , jump+1});
                vis[ind-1] = true;
            }
            if(map.containsKey(val)){
                List<Integer> list = map.get(val);
                if(!list.isEmpty()){
                    int newJump = jump+1;
                    for(int i = 0 ; i < list.size() ; i++){
                        int currInd = list.get(i);
                        if(vis[currInd]){
                            continue;
                        }
                        q.offer(new int[]{val , currInd , newJump});
                        vis[currInd] = true;
                    }
                }
                map.remove(val);
            }
        }
        return -1 ;
    }
}