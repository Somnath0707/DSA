/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1 ,  // This show the start of n
            right = n ;  // This show the end of the n 

        while(left < right ){ // This we use when we have to find the fist occ so that the left crosses right not when left and right is equal
 
            int mid = left + (right - left ) / 2 ; // Normal Mid calculation 
            boolean res = isBadVersion(mid); // As the api return the boolean value good or bad i.e if version is bad it return true so we have to find the first bad version too 


            // From above we know that res is boolean if the res is true this we run(bad version ) 
            if(res){ 
                right = mid ; 
            }else{
                left = mid + 1; 
            }
        }
        return left;
    }
}


// n = 9 bad = 7   
//   G G B B B B B B B 
//   l       m       r

//   --->IF mid is bad we know that first occurence will be in the left of mid as they occure in sequence  .
//   --->So we can just remove the the elements after mid 
//   ---> Imp mid could also be the first occurence of that so we do right = mid;

//   G G B B B
//   l   m   r 

//   --->again mid = bad so we repeat the first step i.e. just reduce the size right = mid 

//   G G B 
//   l m r

//    ---> here mid is not the bad version so 
//    ---> If mid is not the bad version it doesnt make any sense to but left in mid        as version could in the left of mid only 
//    ---> So we do left = mid + 1;
//    --->So we can reduce whole left space too 

//   B
//   l(left)
//   r(right)
//   m(mid)

//   ---> Here left right are at same place 
//   ---> So this condition fails here left < right (as left becomes equal to right )
//   ---> So we come out of the loop and return the left which is the bad version 





   
