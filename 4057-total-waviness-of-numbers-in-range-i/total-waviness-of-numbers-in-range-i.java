class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0 ; 
        for(int i = num1 ; i <= num2 ; i++){
            String str = String.valueOf(i);
            int peak = 0 ; 
            int valley = 0 ; 
            for(int j = 1 ; j < str.length()-1 ; j++){
                int curr = str.charAt(j) -'0';
                int prev = str.charAt(j-1) - '0';
                int next = str.charAt(j+1) -'0';

                if(curr > prev && curr > next) peak++;
                else if(curr < prev && curr < next) valley++; 
            }
            ans += peak + valley;
        }
        return ans; 
    }
}