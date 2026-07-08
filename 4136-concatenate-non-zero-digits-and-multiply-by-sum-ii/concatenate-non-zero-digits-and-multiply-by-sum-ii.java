class Solution {
    int MOD = 1000000007;
    long prefix[]; 
    long[] pow10;
    public long get(int l, int r) {
        if (l == 0) return prefix[r];
        long ans = (prefix[r] - (prefix[l - 1] * pow10[r - l + 1]) % MOD + MOD) % MOD;
        return ans; 
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        // first make a prefix arrray that store the zeros till each point 
        // 1 0 2 0 3 0 0 4 -> 0 1 1 2 2 3 4 4 
        // 1,0 2,2 3,4 4,7 -> 1 2 3 4
        // put them in the tree map 
        // take the index and value in tree map 
        //0 : 1 , 2:2....
        // at each we will take the the key that is curr or greater and for the other we will take the curr or lower so by that we will get the exact postion of first and last number so that we can get it directly from the zeroremoved string and there will be prefix aray aswell so no worry to get the direct sum lmao ;

        // steps get the prefix array of 0s then 0 removed string or array 
        // then prefix sum of the s 
        // tree map that has the index which are non zero 
        // if the ciel and floor is out of the range that mean all zero only so we can just add 0 if that was the case ok 

        int n = s.length(); 
        int prefixZero[] = new int[n]; 
        int prefixSum[] = new int[n]; 
        List<Integer> list = new ArrayList<>();
        

        if (s.charAt(0) == '0') {
            prefixZero[0] = 1;
        } else {
            prefixZero[0] = 0;
        }
        prefixSum[0] = s.charAt(0) - '0';
        for(int i = 1 ; i < n ; i++){
            int val = s.charAt(i) - '0';
            if(val == 0 ){
                prefixZero[i] = prefixZero[i-1] + 1 ; 
                prefixSum[i] = prefixSum[i-1];
                continue; 
            }
            prefixZero[i] = prefixZero[i-1]; 
            prefixSum[i] = prefixSum[i-1] + val ; 
        }
        TreeMap<Integer , Integer> map = new TreeMap<>(); 
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != '0'){
                map.put(i , s.charAt(i) - '0');
                list.add(s.charAt(i)-'0');
            }
        }

        // what is our current arsenal :
        // 1. prefix zero array which has zero at each point
        // 2/. PrefixSum array which gives us the prefix sum 
        // 3. list which has the val with non zero digit number 
        // 4. A tree map to get the location of the number 
        n = list.size();
        if(n == 0 ) return new int[queries.length];
        prefix = new long[n]; 
        pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;;

        prefix[0] = list.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] * 10 + list.get(i)) % MOD;;
        }

        int m = queries.length; 
        int ans[] = new int[m]; 
        for(int i = 0 ; i < m ; i++){
            int curr[] = queries[i]; 
            int left = curr[0]; 
            int right = curr[1]; 

            Integer mapLeft = map.ceilingKey(left);

            if (mapLeft == null || mapLeft > right) {
                ans[i] = 0;
                continue;
            }// get curr or more 
            if(mapLeft > right){
                ans[i] = 0 ; 
                continue; 
            }
            Integer mapRight = map.floorKey(right);

            if (mapRight == null || mapRight < left) {
                ans[i] = 0;
                continue;
            }// get curr or less

            int accLeft = mapLeft - prefixZero[mapLeft]; 
            int accRight = mapRight - prefixZero[mapRight]; 

            long getVal = get(accLeft , accRight);
            int sum = prefixSum[right];
            if (left > 0) {
                sum -= prefixSum[left - 1];
            }

            ans[i] = (int)(((long)getVal * sum) % MOD);            

        }


        return ans ;

    }
}