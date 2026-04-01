class Solution {
    int MOD = 1000000007;
    public long f(int arr[]){
        long curr = 0, max = 0;

        for (int x : arr) {
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }

        return max;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        long totalSum = 0 ; 
        for(int n : arr) totalSum+= n;

        if(k == 1 ) {
            return (int)(f(arr) % MOD) ;
        }

        int twiceF[] = new int[arr.length * 2 ]; 

        for(int i = 0 ; i < arr.length * 2 ; i++){
            twiceF[i] = arr[i % arr.length];
        }
        long max = f(twiceF) ; 
        long res ; 
        if(totalSum > 0){
            res = max + (k-2 ) * totalSum ; 
        }
        else {
            res = max; 
        }

        return (int)(res % MOD);
    }
}

// so basically if k == 1 we use kadane on one only and we get the answer 
// if k >= 2 we do it on 2 as it cover all the cases of the first and last and all that bs 
// ex [1,-2,1] k = 3 [1,-2,1,1,-2,1,1,-2,1] here combining 3 we get the answer as 2 but the question is do we even need all the 3 lmao no just two are enought for that 
// [1,-2,1,1,-2,1]

// Example (IMPORTANT)
// arr = [1, -2, 1]
// k = 5
// totalSum = 0

// 👉 no benefit from repetition
// 👉 answer = kadane(arr + arr)

// Now change:
// arr = [2, -1, 2]

// totalSum = 3 (>0)

// Now:

// [arr, arr] → gives best prefix+suffix combo
// middle arrays → just add full sum

// So:

// result = maxTwice + (k-2)*3

// nah bs problem fuck this nigga
// this problem is so fucking annoying 

