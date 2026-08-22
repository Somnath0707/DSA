class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0 ; 
        long mul = 1L ; 
        String str = String.valueOf(n); 
        for(int i = 0 ; i < str.length() ; i++){
            int val = str.charAt(i)-'0';
            sum += val ; 
            mul *= val; 
        }

        long total = sum + mul ; 
        if(n % total == 0) return true; 
        return false; 
    }
}