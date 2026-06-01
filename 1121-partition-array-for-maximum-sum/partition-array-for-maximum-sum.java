class Solution {

    int ans = 0 ; 
    public Map<String,Integer> dp ; 
    public int max(int ind , int j , int arr[] ){
        int max = -1; 
        for(int i = ind ; i <= j ; i++){
            if(arr[i] > max){
                max = arr[i]; 
            }
        }
        return max; 
    }
    public int f(int i , int arr[] , int k ){
        if(i == arr.length){
            return 0  ;
        } 

        String key = String.valueOf(i); 

        if(dp.containsKey(key)) return dp.get(key);

        int n = arr.length;
        

        for(int j = 1 ; j <= k ; j++){

            if(j + i > n ) break ; 

            int curr = max(i , i+ j-1 ,arr ) * (j); 

            ans = Math.max( ans , curr + f(j+i  , arr, k ));
        }
        // we have to get max in this range 
        // how can we store the answer for each complete check 

        int  temp = ans; 
        dp.put(key , ans);
        return temp;

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Lol constraints are pretty small so maybe dp most probably 

        // for each we try each subarray from 1 to k this is surely the answer 

        // for first subarray we try size one size 2 size 3 size 4 and for each we take next subarray and try try all the size too lmao 

        // so suppose k = 3 we take first the one for size one the child will be of size 1 2 or 3 and so on for all the child till we reach the end 

        // end is what end is end of array 
        // so like we need to check all the combinartin ish we can do that using like 3 dp 

        // in the recurive function we can use the for loop for each size of the sub array 

        // each subarray could choose the independent subarray within the the constraint k so one subbarray could be of size 2 one could be 4 etc 
        int n = arr.length ;
        dp = new HashMap<>();

        

        return f(0, arr , k );
    }
}