class Router {

    Map<Integer,Map<Integer,HashSet<Integer>>> sourceToDestToTime; 
    Map<Integer,List<Integer>> destToTime;
    Map<Integer,Integer> removedForDest; 
    Queue<int[]> q ; 
    int n ;  
    public Router(int memoryLimit) {
        n = memoryLimit; 
        q = new LinkedList<>(); 
        sourceToDestToTime = new HashMap<>(); 
        destToTime = new HashMap<>();
        removedForDest = new HashMap<>(); 
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        if(sourceToDestToTime.containsKey(source) && sourceToDestToTime.get(source).containsKey(destination) && sourceToDestToTime.get(source).get(destination).contains(timestamp)){
            return false; 
        }
        else{
            sourceToDestToTime.putIfAbsent(source , new HashMap<>());
            sourceToDestToTime.get(source).putIfAbsent(destination, new HashSet<>());
            sourceToDestToTime.get(source).get(destination).add(timestamp); 
            destToTime.putIfAbsent(destination , new ArrayList<>());
            destToTime.get(destination).add(timestamp);
            q.offer(new int[]{source , destination , timestamp});
        }

        if(q.size() > n){
            int curr[] = q.poll(); 
            int currSrc = curr[0]; 
            int currDest = curr[1]; 
            int currTime = curr[2] ; 

            sourceToDestToTime.get(currSrc).get(currDest).remove(currTime); 
            if(sourceToDestToTime.get(currSrc).get(currDest).isEmpty()){
                sourceToDestToTime.get(currSrc).remove(currDest); 
                if(sourceToDestToTime.get(currSrc).isEmpty()){
                    sourceToDestToTime.remove(currSrc); 
                }
            }
            
            removedForDest.put(currDest , removedForDest.getOrDefault(currDest , 0)+1);
        }

        return true; 
    }
    
    public int[] forwardPacket() {
        if (q.isEmpty()) {
            return new int[]{};
        }
        int curr[] = q.poll(); 
        int currSrc = curr[0]; 
        int currDest = curr[1]; 
        int currTime = curr[2] ; 

        sourceToDestToTime.get(currSrc).get(currDest).remove(currTime); 
        if(sourceToDestToTime.get(currSrc).get(currDest).isEmpty()){
            sourceToDestToTime.get(currSrc).remove(currDest); 
            if(sourceToDestToTime.get(currSrc).isEmpty()){
                sourceToDestToTime.remove(currSrc); 
            }
        }
        
        removedForDest.put(currDest , removedForDest.getOrDefault(currDest , 0)+1);

        return curr; 
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = destToTime.get(destination);
        int start = removedForDest.getOrDefault(destination , 0); 
        if (list == null) return 0;
        int right = list.size()-1; 
        int ans = bs( start ,  right , list , startTime , endTime); 
        return ans; 
    }

    public int bs(int left , int right , List<Integer> list , int startTime , int endTime){
        int lower = -1; 
        int higher = -1 ; 
        // 90 105 105 107
        int l = left ; 
        int r = right; 
        while(l <= r){
            int mid = l + (r-l)/2; 
            if(list.get(mid) >= startTime){
                lower = mid; 
                r = mid-1; 
            }
            else{
                l = mid+1; 
            }
        }
        if(lower ==-1) return 0; 
        while(left <= right){
            int mid = left+(right-left)/2; 
            if(list.get(mid)<= endTime){
                higher= mid; 
                left = mid+1; 
            }else{
                right = mid-1; 
            }
        }
        if(higher == -1) return 0 ; 

        return higher - lower +1; 
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */