class Solution {
    public int longestDecomposition(String s) {
        

        int left =0 ; 
        int right = s.length()-1; 
        int ans = 0 ;

        while(left <= right){
            boolean found = false; 
            for(int i = left ; i <= right ; i++){
                String leftSubstring = s.substring(left , i+1); 
                int len = i - left+1; 
                String rightSubString = s.substring(right - len +1, right+1);

                if(leftSubstring.equals(rightSubString)){
                    if(i == right){
                        ans+=1; 
                    }else ans+=2; 
                    left = i+1;
                    right -= len ;  
                    found = true; 
                    break;
                }
            }
            // break;
            if(!found) break;

        }

        if(ans ==0) return 1; 
        return ans; 
    }
}