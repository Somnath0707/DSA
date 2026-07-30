class Solution {
    public int minimumPushes(String word) {
        int n = word.length(); 
        int ans = 0 ; 
        if(n <= 8 ) return n ; 
        else if (n <=16){
            int temp = 8 ; 
            int total = (n - 8) * 2; 
            ans = temp + total ; 
        }
        else if((n <= 24)){
            int total = (n - 16)* 3; 
            ans = 8 + 16 + total; 
        }
        else{
            int total = (n - 24) * 4; 
            ans = 8 + 16 + 24 + total;
        }
        return ans ; 
    }
}