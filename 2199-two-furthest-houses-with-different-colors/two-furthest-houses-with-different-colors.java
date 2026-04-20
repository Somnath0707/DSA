class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0 ; 
        for(int i = 0 ; i< colors.length-1 ; i++){
            int diff = 0 ; 
            for(int j = 0 ; j < colors.length ; j++){
                if(colors[i] != colors[j]){
                    diff = Math.abs(j-i);
                }
            }
            ans = Math.max(diff , ans);
        }
        return ans;
    }
}