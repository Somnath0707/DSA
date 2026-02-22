class Solution {
    public boolean isDigitorialPermutation(int n) {
        int ans = 0; 
        int original  = n ;

        if(n ==0) ans = fact(0);
        else 
        {while(n >0 ){
            int num = n % 10;
            ans += fact(num);
            n = n /10;
        }}

        
        return isAns(ans , original  );
        
    }

    public boolean isAns(int ans , int n ){
        char[] a = String.valueOf(ans).toCharArray();
        char[] na = String.valueOf(n).toCharArray();

        Arrays.sort(a);
        Arrays.sort(na);

            return Arrays.equals(a, na);
    }

    public int fact( int num){
        int facto = 1 ;
        for(int i =1  ; i <= num ; i++){
            facto*=i;
        }
        return facto;
    }
}