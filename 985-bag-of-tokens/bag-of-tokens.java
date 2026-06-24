class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // we have an intital powr of power an intital score of 0 and a bag of toek given as an intetger array token wher each tokens[i] denotes the value of token 
        Arrays.sort(tokens);

        int i = 0 ; 
        int j = tokens.length-1 ; 
        int max = 0 ; 
        int ans = 0; 

        while(i <= j ){
            if(tokens[i] <= power){
                power -= tokens[i]; 
                i++; 
                ans++; 
                max = Math.max(max , ans); 
            }
            else if(i == j ){
                if(tokens[i] > power){
                    j--; 
                }
            }
            else if(ans > 0){
                power += tokens[j]; 
                j--; 
                ans--; 
            }else {
                break;
            }
        }

        return max; 
        
    }
}