class Solution {
    public long f(long n , int target){
        String num = String.valueOf(n);
        String tar = String.valueOf(target);
        long len = tar.length(); 
        StringBuilder str = new StringBuilder(); 
        long ans = 0;

        long total = 0 ;
        for(int i = 0 ; i < num.length() ; i++){
            long temp = Long.parseLong(num.substring(i,i+1));

            total += temp; 
            if(total < target){
                str.append(temp);
            }
            else if(total >= target){
                if(str.isEmpty()) {
                    ans = 1; 
                }
                else 
                ans = Long.parseLong(str.toString()) + 1;
                str = new StringBuilder();
                str.append(ans);
                for(int j = 0 ; j < num.length() - i ; j++){
                    str.append("0");
                }
                ans = Long.parseLong(str.toString());
                break;
            }
        }

        System.out.println(ans);
        return ans; 

    }


    public long makeIntegerBeautiful(long n, int target) {
        String str = String.valueOf(n);
        long sum = 0 ; 
        for(int i = 0 ; i < str.length(); i++){
            sum += Long.parseLong(str.substring(i, i+1 ));
        }
        if(sum <= target) return 0 ; 
        long temp = f(n , target);
        if( temp == 0 ) return 0 ;
        long ans =temp - n;
        if( ans < 0){
            temp *= 10; 
        }
        ans = temp - n ; 

        return ans; 

    }
}


// 467 -> 17
// 1000 -> 6