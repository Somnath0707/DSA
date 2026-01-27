class Solution {
    public int minLengthAfterRemovals(String s) {
        
        int countA = 0 ;
        int countB = 0 ; 

        for(char ch : s.toCharArray()){
            if(ch == 'a') countA++;
            else countB++;
        }

        return Math.abs(countA - countB);
    }
}