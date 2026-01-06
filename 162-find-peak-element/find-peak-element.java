class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0 ,
            right = nums.length - 1 ;

        while(left < right ){
            int mid = left + (right - left) / 2; 
            if(nums[mid] > nums[mid + 1]){
                right = mid ; 
            }
            else if(nums[mid]<nums[mid + 1]){
                left = mid + 1; 
            }
        }
        return left; 
    }
}

///  1 3 4 5 6 8 4 5 3 2 1
//  Peak of Mounation means the nums keep increasing and until ceratin point and as we reach the highest point the number start to descrease .

// So to find peak we know the peak is highest value in the array 
// So we can do it using the noraml search be it is mentioned O(log n) 
// so its obvious that we need to use binary search 
// The starting steps as usual left = 0 right = length - 1 and mid

// 1 3 4 5 6 8 4 5 3 2 1
// l         m         r 

// So if mid > mid + 1 i.e. suppose mid(4) 3 2 1 if mid is greater than next element we know that the values are decreasing so the peak should be at mid or left of mid 
// So we do right = mid 

// So now 
// 1 3 4 5 6 8 
// l     m   r

// Here mid < mid + 1  i.e. next element is greater than mid
// So the peak could not be the mid , It could be either mid + 1 or further to right 
// So we left = mid + 1; 

//  6 8 
//  l r
//  m


// Here mid < mid + 1  so previous step 
// 8
// l
// r
// m


// Here the while condition is false as l is not less than right so loop break 
// we return the Left 

// i.e. peak of the array 