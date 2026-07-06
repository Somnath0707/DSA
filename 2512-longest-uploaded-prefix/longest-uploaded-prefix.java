class LUPrefix {
    boolean arr[] ;
    int count  = 0 ; 
    int i = 0 ; 
    public LUPrefix(int n) {
        arr = new boolean[n+1]; 
    }
    
    public void upload(int video) {
        arr[video-1] = true; 
        // int n = arr.length;
        // for(int i =0 ; i < n ; i++){
        //     System.out.println(arr[video-1]);
        // }
    }
    
    public int longest() {
        while(arr[i]){
            count++; 
            i++; 
        }
        return count; 
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */