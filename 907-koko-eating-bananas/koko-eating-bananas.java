class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0 ; 

        for (int i = 0 ; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int left = 1; 
        int right = max;
        int result = 0 ; 

        while(left<= right ){
            int mid = left + (right - left ) / 2 ; 
            if(calclateSpeed(piles,mid)<= h){
                result = mid ; 
                right = mid - 1 ;
            }else{
                left = mid + 1 ; 
            } 
        }
        return result;
    }

    private long calclateSpeed(int[] piles, int k ){
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (long) Math.ceil((double) piles[i] / k);
        }
        return hours;
    }
}