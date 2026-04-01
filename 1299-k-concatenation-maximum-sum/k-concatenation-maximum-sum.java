class Solution {

    int MOD = 1000000007;


    public long f(int arr[]){
        long max = 0 ; 
        long curr = 0 ; 

        for(int n : arr){
            curr = Math.max(n , curr + n );
            max = Math.max(curr , max ) ; 
        }
        return max ; 
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        // get the total sum 
        long totalSum = 0 ; 
        for(int n : arr) totalSum += n ; 

        // if k is only one 
        if( k == 1 ){
            return (int) (f(arr) % MOD );
        }

        int n = arr.length ; 
        int twiceArr[] = new int[2 * n];


        // puth the 2 x into the array 
        for(int i = 0 ; i < n * 2 ; i++){
            twiceArr[i] = arr[i % n ]; 
        }

        long max = f(twiceArr);

        long res; 

        if( totalSum > 0 ) { 
            res = max + (k - 2 ) * totalSum ; 
        }
        else {
            res = max; 
        }

        return (int)(res % MOD);
    }
}