class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int first = values[0] +0 ; 
        int max = 0 ; 

        for(int j = 1 ; j < values.length ; j++){
            int second = values[j] - j ;
            max = Math.max(max , first + second ) ; 
            first = Math.max(first , values[j] + j ) ; 
        }

        return max ; 
    }
}