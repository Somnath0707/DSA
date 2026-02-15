class Solution {
    public String addBinary(String a, String b) {
        int sum =0 ; 
        int carry = 0;
        int m = a.length()-1;
        int n = b.length()-1; 
        StringBuilder str = new StringBuilder();

        while(m>=0|| n>=0){
            sum = carry;

            if(m >=0){
                sum+= a.charAt(m) - '0';
                m--;
            }
            if(n>=0){
                sum+= b.charAt(n)-'0';
                n--;
            }
            if(sum%2 ==0){
                str.append('0');
            }else{
                str.append('1');
            }

            if(sum>1) carry = 1;
            else carry = 0;
        }
        if(carry>0){
            str.append('1');
        }

        str.reverse();

        return str.toString();
    }
}