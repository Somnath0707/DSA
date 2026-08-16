class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE; 
        int ans = -1; 
        int n = drones.length ; 
        for(int i = 0 ; i < n ; i++){
            int x = drones[i][0]; 
            int y = drones[i][1]; 

            int range = drones[i][2]; 

            int val = Math.abs(x - target[0]) + Math.abs(y - target[1]);
        
            if(val <= range){
               if(val < min){
                   ans = i ; 
                   min = val; 
               }
                
            }
        }
        return ans ; 
    }
}