class Solution {
    public int findMin(int[] nums) {
        int left = 0, 
            right = nums.length-1 ;

        while(left < right ){
            int mid = left + (right - left) / 2 ;
            if(nums[mid] < nums[right]){   //[3,4,5,1,2] we know here 5 is mid and 2 is right so mid is greater than right so we know that left side is sorted but the element is to the right of the list 
            right = mid; 
            } 
            else if(nums[mid] > nums [right]){ // we know that the left side is sorted and smaller no is on the left of the mid 

            // Minimum is at mid or in the left half
            left = mid+1;

            }
            else{
                right--;
            }
        }
        // here we return the left value cause we know which ever side the array is sorted the value will be to left of it 
        return nums[left];
    }
}