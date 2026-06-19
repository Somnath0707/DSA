class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length; 
        int max = Math.max(0 , gain[0]);
        int prev = gain[0]; 
        for(int i = 1 ; i < n ; i++){
            prev += gain[i]; 
            max =Math.max(max , prev);
        }
        return max;
    }
}