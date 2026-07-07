class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder str = new StringBuilder();
        long sum = 0 ; 
        String temp = String.valueOf(n);
        for(int i = 0 ; i < temp.length() ; i++){
            if(temp.charAt(i) -'0' != 0){
                str.append(temp.charAt(i));
            }

            sum += temp.charAt(i) - '0';
        }
        if(n == 0) return 0 ; 
        int val = Integer.parseInt(str.toString());
        return val * sum ; 
    }
}