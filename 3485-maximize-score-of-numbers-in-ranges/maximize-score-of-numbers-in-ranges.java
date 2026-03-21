class Solution {
    public boolean f(int mid , int[][] arr  ){
        long last = arr[0][0];

        for(int i = 1 ; i < arr.length ; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            long pick = Math.max(start , last + mid);

            if(pick > end ) return false; 

            last = pick;
        }
        return true;
    }
    public int maxPossibleScore(int[] start, int d) {
        int [][] arr = new int[start.length][2];

        for(int i = 0 ; i < start.length ; i++){
            arr[i][0] = start[i];
            arr[i][1] = start[i] + d; 
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0 ; 
        int right =  (int)2e9 + 5;
        int ans = 0; 

        while(left <= right ){

            int mid = left + (right - left) / 2 ;

            if(f(mid , arr )){
                ans = mid; 
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ; 
            }
        }
        return ans;
    }
}

//start = [6,0,3], d = 2
// first range->[6,8]->
// second range [0,2]->
// third range [3,5]->

// 6,8->
// 3,5->
// 0,2->


/// take the max and min as it is  and do binary search on the middle element 