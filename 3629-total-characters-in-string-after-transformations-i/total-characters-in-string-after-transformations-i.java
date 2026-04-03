class Solution {
    int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long arr[] = new long[26];

        for(char ch : s.toCharArray()){
            int ind = ch -'a';
            arr[ind]++;
        }

        for(int i = 0 ; i < t ; i++){
            long temp[] = new long[26]; 
            for(int j = 0 ; j < 26 ; j++){
                if(arr[j] == 0 ) continue;

                if(j == 25 ){
                    temp[0] =( temp[0] + arr[j]) % MOD;
                    temp[1] = (temp[1] + arr[j]) % MOD;
                }
                else{
                    temp[j+1] =( temp[j+1 ] + arr[j]) % MOD;
                }
            }
            arr = temp;
        }
        long ans = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            ans = ((ans + arr[i]) % MOD); 
        }
        return (int)ans ;
    }
}



// for every char if arr[i] == 1 arr[i] - 1 arr[i+1] + 1 
// if ch == z arr[26 ]-1 arr[0] +1 arr[1] + 1 

// after total count the total int the array 