class Solution {
    public int minFlipsMonoIncr(String s) {
        int one = 0; 
        int zero = 0 ; 
        int n =s.length();
        boolean startCount = false;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1' && startCount == false ){
                startCount = true; 
                one++; 
            }
            else if(startCount){
                if(s.charAt(i) =='1') one++; 
                else{
                    zero++; 
                    zero = Math.min(zero , one);
                }
            }
        }
        return zero;
    }
}