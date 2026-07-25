class Solution {
    public int maxProduct(int n) {
        int max =0 ; 
        int secondMax = 0 ; 

        for(char ch : String.valueOf(n).toCharArray()){
            int num = ch - '0';
            if(num >= max){
                secondMax = max; 
                max = num; 
                continue; 
            }
            else if(num >= secondMax){
                secondMax = num ; 
            }
        }

        return max * secondMax;
    }
}