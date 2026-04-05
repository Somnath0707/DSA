class Solution {
    public boolean judgeCircle(String moves) {
        int U = 0 , D = 0 , R = 0 , L = 0 ; 

        for(char ch : moves.toCharArray()){
            if(ch == 'U') U++;
            else if(ch =='D') D++;
            else if(ch =='R') R++;
            else if(ch =='L') L++;
        }

        if(D - U == 0 && R -L ==0) return true; 
        return false ; 
    }
}