import java.util.*;

class Solution {

    Long dp[][][][][][];

    boolean isGoodSum(int sum){

        String s = String.valueOf(sum);

        boolean inc = true;
        boolean dec = true;

        for(int i = 1; i < s.length(); i++){

            if(s.charAt(i) <= s.charAt(i-1)) inc = false;
            if(s.charAt(i) >= s.charAt(i-1)) dec = false;
        }

        return inc || dec;
    }


    long f(String s , int i , int prev , int tight , int dir , int good , int leadZero , int sum){

        if(i == s.length()){

            if(leadZero == 1) return 1;

            if(good == 1) return 1;

            if(isGoodSum(sum)) return 1;

            return 0;
        }

        if(tight == 0 && dp[i][prev+1][dir][good][leadZero][sum] != null)
            return dp[i][prev+1][dir][good][leadZero][sum];

        int limit = (tight == 1) ? s.charAt(i) - '0' : 9;

        long ans = 0;

        for(int digit = 0; digit <= limit ; digit++){

            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;

            if(leadZero == 1 && digit == 0){

                ans += f(s , i+1 , prev , nextTight , dir , good , 1 , sum);
                continue;
            }

            if(leadZero == 1){

                ans += f(s , i+1 , digit , nextTight , 0 , 1 , 0 , sum + digit);
                continue;
            }

            int newDir = dir;
            int newGood = good;

            if(good == 1){

                if(dir == 0){

                    if(digit > prev) newDir = 1;
                    else if(digit < prev) newDir = 2;
                    else newGood = 0;
                }
                else if(dir == 1 && digit <= prev) newGood = 0;
                else if(dir == 2 && digit >= prev) newGood = 0;
            }

            ans += f(s , i+1 , digit , nextTight , newDir , newGood , 0 , sum + digit);
        }

        if(tight == 0)
            dp[i][prev+1][dir][good][leadZero][sum] = ans;

        return ans;
    }


    long solve(String s){

        dp = new Long[20][11][3][2][2][140];

        return f(s , 0 , -1 , 1 , 0 , 1 , 1 , 0);
    }


    public long countFancy(long l, long r) {

        long ans1 = solve(String.valueOf(r));
        long ans2 = solve(String.valueOf(l - 1));

        return ans1 - ans2;
    }
}