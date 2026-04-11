class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0 ; 
        for(int i= num1 ; i <= num2 ; i++){
            String str = Integer.toString(i);
            int n = str.length() ; 
            int wave = 0 ; 
            int peak = 0 ; 
            for(int j = 1 ; j < n -1 ; j++){
                int curr = str.charAt(j) - '1';
                int prev = str.charAt(j-1) - '1';
                int next = str.charAt(j+1) - '1';
                if(curr > prev && curr > next){
                    wave++;
                }
                else if(curr < prev && curr < next){
                    peak ++;
                }
            }
            ans += wave + peak;
        }
        return ans;
    }
}