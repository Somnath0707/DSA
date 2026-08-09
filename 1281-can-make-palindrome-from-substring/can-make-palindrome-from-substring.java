class Solution {
    public boolean check(int left , int right , int k , int nums[][]){
        right++;
        int curr[] = new int[26]; 
        for(int i = 0 ; i < 26 ; i++){
            curr[i] = nums[right][i] - nums[left][i];
        }

        int total = 0 ; 
        int even = 0 ; 
        int odd = 0 ; 
        for(int i =0 ; i < 26 ; i++){
            if(curr[i] % 2 == 0) even++; 
            else odd++; 
            total += curr[i]; 
        }

        // System.out.println(odd + " "  + even );

        if(total % 2 == 0){
            if(odd == 0) return true; 
            // aabcccc// in one operatoin we can make odd -1 and even +2 
            // abcacdd odd 2 even 1 odd-=2 and even +=1 ok ine one operaton we can remove only one odd is not possible 
            // total  odd /2 <= k then we can make them even 
            if(odd /2 <= k) return true; 
            return false; 
        }
        else {
            if(odd == 1 ) return true; 
            if((odd-1) / 2 <= k) return true; 
            return false; 
        }


    }
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // we can rearrange ok then it just we have to find the same number of the 
        // we need something 

        // suppose i did something like prefix sum but based on the index for 0 1 2 3 and then while query we take prefix sum of upper - lower and then get total numbre of valuee sum and get the even and odd  and check if there are total odd values then the we need 1 odd and rest of them as even if we can make them even and odd then we get the answer within k moves 
        // we have aaabbbccd now we have 3 odd one even we have to some how make 
        // and suppose k is 2 we can we can remove one odd and make 2 even in one move so aadbbbccd -> adcbbbcda

        // so we can hve is like  prefix sum but [i][26] and get the answer each operation will be 0(2*26)  wich is constant 
        // yeah this is the anser 
        int n = s.length(); 
        int prefix[][] = new int[n+1][26]; 

        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < 26 ; j++){
                prefix[i][j] = prefix[i-1][j];
            }
            
            prefix[i][s.charAt(i-1)-'a']++;
        }


        int m = queries.length ; 
        List<Boolean> list = new ArrayList<>(); 
        for(int i = 0 ; i < m ; i++){
            int left = queries[i][0];
            int right = queries[i][1]; 
            int k = queries[i][2]; 
            list.add(check(left , right , k , prefix));

        }
        return list; 

    }
}
// abcdd
// in one operation if there is alreay odd we can make 2 even or if we have to make even the we cha ve 

// if there are even number we need all even if there is odd number we need one odd rest even 

// shezu -> zu 2