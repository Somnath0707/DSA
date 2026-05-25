class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // 1 2 3 10 12 9 10 10 10 10 10 2 3 2 3 3
        // 1 2 3  4  5 1  2  3  4  5  6

        // here if we get the decreasing get the the range that is greater than the curr and check which has the greater bigger sub array 
        // in above example we get the dec in the 9 and the max inc here is 6 
        // the number in array that appear before 9 and and are greater than 9 till the index before the 9 in that range we have 2 elements so we can remove the smaller sub array which is 10 and 12 but once we have removed the subarray we cant remove another subarry so after that we remove all the rest of the subarray if till end if there does not exist any sub array that is greater than the current range 
        

        // Get the sorted prefix 
        int n = arr.length;
        int j = n-1; 
        while(j >= 1 ){
            int curr = arr[j];
            int prev = arr[j-1];
            if(curr < prev){
                break;
            }
            j--;
        }
        if(j == 0 ) return 0;
        
        int sortedSuffix = n-j-1;
        // we go till the the number that is greater than the suffix or the one where the unsorted begin 
        int i = 0 ;
        while(i < n-1){
            int curr = arr[i];
            int next = arr[i+1];

            if(curr > next){
                break;
            }
            i++;
        }
        // if(j == n-1) return n-i-1;

        // break means the case is we have got number or index to check which has the better sub aarry 
        // now we have the the left sorted and right sorted in place 
        int left = 0 ; 
        int right = j;
        int minToRemove = Math.min(n - 1 - i, j);
        while(left <= i && right < n){
            if (arr[left] <= arr[right]) {
                minToRemove = Math.min(minToRemove, right - left - 1);
                left++; // Move left forward to see if we can include more of the prefix
            } else {
                // arr[left] is too big, we need a larger element from the suffix
                right++;
            }
        }
        return minToRemove;
    }
}