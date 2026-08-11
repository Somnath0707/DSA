class Solution {
    public long appealSum(String s) {
        // 1 2 2 3 3 
        // 1
        // 2 * 1 + 1 = 1 * 2 + 2 * 1 = 2 + 2 = 4 
        // 2 * 3 = 6 , so dup was there so we do 4 +3  =  7 
        //2 * 6 = 12 , no dup so 7 were there so total 7 + 2 + 3 +1

        // at each point check how many unique values are there and is the value unique or not 
        // a unique total = 1 and unique = 1 
        // ab unqiue =2 total 2 * prev + 1 are total substring 3 sub string 2^2 values are unqiue = 4 values total 
        // a b b unique = 2  , total substring are 6 prev we found answer for 3 which is 3 now answer for 6 is in new 3 formed string there is one dup the answer would be 4 + 3 // if dup were not there answer would have been total new string * 2
        // here answer is 4 + 4 = 7 instead of 6 we get 4
        //a b b c new appean total sub string = 4 (4+1)/ 2 so 10 prev we had for 6 now reamaining 4 and there one is dup here too if all are sep the answer is len 4(4+1)/2 = 10 10 would have been added but 1 dup took 2 awaay 8 + 8 = 16
        // a b b c a 15 sub stringtotal which 10 has already been delt so new are 5 
        // there are two dups out out of 5 1 + 2 + 3 + 3 + 3 = 12  so 16 + 12 = 18 

        // what is the relation between the number of dups and the total added 
        //  for len 4 total added should have been 10 but 1 dup and 8 added 
        // for len 5 total added should have been 15 but added was 12 

        // what is the relation 
        // a b b c a d 6 total len is 6(6+1 ) /2  21 out of which 15 are added 6 2 dups
        // total added should be 21 but how much is added 1 2 3 4 4 4 = 18
        // for every dup added we reduce the total by 1 3 5 what me to prove it

        // if it were a b b a c a then total if all were unique 21 would have been added but as there are 3 dups 2 3 4 total added would be 18-5 that is 2 dups for 

        // 3 unqiue 1 2 2  3 3 3
        int n = s.length(); 
        long dp[] = new long[n];
        dp[0] = 1 ; 
        long ans = 1 ; 
        
        Map<Character,Integer> map = new HashMap<>(); 
        map.put(s.charAt(0) , 0);

        for(int i = 1 ; i < n ; i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                int lastSeen = map.get(ch);
                dp[i] = dp[i-1] + (i - lastSeen); 
            }
            else{
                dp[i] = dp[i-1]+ (i+1); 
            }
            map.put(ch , i); 
            ans += dp[i]; 
        }

        return ans;
    }
}