class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //return non empty subarrays in the range left and right
        if(left == 0 ) return 0; 

        // try the subarray until the large number is ther than take all the number of sub array possible there example 2 1 4 3 2 and 3 so whnever ever the condition break ex here 2 1 ok at 4 the condition break so the len is 2 the total possible subarray of of len 2 is 2 only so we can derive that formula 

        // but  if the value is less than left its ok cause there may come a value that can have the value greater than this 
        
        int max = -1; 
        int continueSmaller = 0 ; 
        long combined = 0 ; 
        int n = nums.length; 
        int count = 0 ; 
        int i = 0 ; 
        int lessNum = 0 ;
        long ans = 0 ; 
        boolean prev = false; 
        // boolean isContinue  = false; 
        for(int j = 0 ; j < n ; j++){
            int val = nums[j]; 
            max = Math.max(max , val); 
            // System.out.println(j + " max " + max);
            if(val <= right ){
                // ans++; 
                if(val < left){
                    if(prev){
                        continueSmaller++ ; 
                    }
                    else{
                        prev = true; 
                        continueSmaller ++;
                    }
                    lessNum++; 
                }else {
                    combined += 1L * continueSmaller*(continueSmaller +1 ) / 2; 
                    lessNum -= continueSmaller; 
                    continueSmaller = 0 ; 
                    prev = false; 
                }
                count++; 
                
            }
            else{
                // if(count == 2)
                combined += 1L *continueSmaller*(continueSmaller +1 ) / 2;
                continueSmaller = 0 ; 
                prev = false; 
                ans += 1L *count*(count+1) / 2; 
                lessNum = 0 ; 
                count = 0 ; 
                max = -1;
                // System.out.println(j + " " + i  + " ans till now is " + ans); 
                if(j == n-1){
                    break; 
                }
                else{
                    i++; 
                }
                

            }
            
        }

        if(count != 0 ){
            combined += 1L * continueSmaller*(continueSmaller +1 ) / 2; 
            ans += 1L * count*(count+1) / 2;
        }

        // 1 2 4 3 3 3 3 

        return (int)(ans - combined); 
    }
}