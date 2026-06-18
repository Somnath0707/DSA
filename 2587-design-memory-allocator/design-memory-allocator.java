class Allocator {
    int arr[]; 
    int len ; 
    Map<Integer,Integer> map; 
    public Allocator(int n) {
        len = n ; 
        arr = new int[n]; 
        map = new HashMap<>();
    }
    
    public int allocate(int size, int mID) {
        int count = 0; 
        boolean flag = false; 
        int foundAt = -1; 
        if(size > len ) return -1 ;
        for(int i = 0 ; i < len ; i++){
            if(arr[i] == 0 ){
                count++; 
                if(count == size){
                    foundAt = i-size+1; 
                    map.put(mID , map.getOrDefault(mID , 0 ) + size ) ; 
                    for(int j = foundAt ; j < foundAt + size ; j++){
                        arr[j] = mID; 
                    }
                    flag = true; 
                }
            }
            else{
                count = 0 ; 
            }
            if(flag) break;
        }
        return foundAt; 
    }
    
    public int freeMemory(int mID) {
        for(int i =0 ; i < len ; i++){
            if(arr[i] == mID) arr[i] = 0 ; 
        }
        int ans =0 ; 

        if(map.containsKey(mID)){
            ans = map.get(mID);
            map.remove(mID);
        }
            
        return ans ; 
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */