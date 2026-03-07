class Solution {
    public boolean allocatePos(int minPos , int positions [] , int m){
        int ballsPlaced = 1 ; 
        int lastPos = positions[0];

        for(int i = 1 ; i < positions.length ; i++){
            if(positions[i]- lastPos >= minPos){
                ballsPlaced ++;
                lastPos = positions[i];
            }
            if(ballsPlaced >= m) return true;
        }
        return false; 
    }
    public int maxDistance(int[] position, int m) {
        if(m > position.length) return -1 ; 
        Arrays.sort(position);

        int left = 1; 
        int right = position[position.length-1] - position[0];

        int ans = 0; 
        while(left <= right){
            int mid = left + (right - left ) / 2 ;
            if(allocatePos(mid , position , m ) ){
                ans = mid ;
                left = mid + 1; 
            }else {
                right = mid - 1 ; 
            }
        }
        return ans ;
    }
}