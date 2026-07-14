class Solution {
    public int minFlipsMonoIncr(String s) {
        int one = 0; 
        int zero = 0 ; 
        int n =s.length();
        boolean startCount = false;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1' ){
                startCount = true; 
                one++; 
            }
            else if(startCount){
                if(s.charAt(i) =='0'){ zero++; 
                zero = Math.min(zero , one);
                }
                else one++; 
            }
        }
        return zero;
    }
}