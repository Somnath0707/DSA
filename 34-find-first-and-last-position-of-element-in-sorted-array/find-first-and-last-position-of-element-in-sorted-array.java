class Solution {
    public int[] searchRange(int[] nums, int target) {
        // To return the elements directly from the private function we make 
        return new int[] {first(nums, target )  , last(nums , target)};
    }

    // Function that would return the first occurence 
    private int first(int [] arr , int target){
        // Binary Search Basics eh 
        int left = 0 ; 
        int right = arr.length -1; 
        // To to store the mid and if there no value it will directly give -1 
        int ans = -1;

        // Standard Binary Search Conditon 
        while(left<=right){
            int mid = left + (right - left) / 2;

            
            // If the mid is target that does not guranetee that its the first occurence duh
            // But it does tell us that the first occurrence is at mid or left to mid 
            if(arr[mid] == target ){

                // So we store the mid in ans in case if thats the first occurence 
                ans = mid;
                // Then we make the right to the mid -1
                right = mid - 1;
            }
            // If the target is greater than the ofc it would be to right side of the mid 
            else if (arr[mid]<target){
                left = mid + 1; 
            }
            // If the target is not in the mid not greater than mid it surely would be in left of mid or not present at all 
            else{
                right = mid -1 ; 
            }
        }
        // Return what ever that answer is 
        return ans ; 

    }


    private int last (int [] arr , int target){
        int left = 0; 
        int right = arr.length-1;
        int ans = -1;

        while(left <= right ){
            int mid = left + (right - left )/2; 

            if (arr[mid] == target ){
                ans = mid ;
                left = mid+1 ; 
            }
            else if (arr[mid]>target ){
                right = mid -1;
            }else{
                left = mid + 1; 
            }
        }
        return ans ;
    }
}

//. nums   = [1,2,2,2,2,3,4,5,5,5,6,7,8,8,8,8,9]   target = 8  left = 0 right = 16 so mid = 0
//.           l               m               r


// So the mid < target so left = mid + 1


//.  [1,2,2,2,2,3,4,5,5,5,6,7,8,8,8,8,9]
//.                       l     m     r


// Here mid == ans but we can see the element 8 first occurence is to left of the mid so 
// We store the answer ans = mid ; and then check for the left so right = m -1 ;

//.  [1,2,2,2,2,3,4,5,5,5,6,7,8,8,8,8,9]
//.                     l   m r    

// here mid is less than target so we do left = mid 