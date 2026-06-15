class Solution {
    public boolean checkGoodInteger(int n) {
        long sum = 0 ; 
        int sqrSum = 0 ; 

        String str = String.valueOf(n);
        for(char ch : str.toCharArray()){
            long num = ch -'0';
            sum += num;
            sqrSum += num * num;
        }

        long ans = sqrSum - sum;
        if(ans >= 50) return true; 
        return false;
    }
}