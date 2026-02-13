class Solution {
    public boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                count++;
                if (count > 1) return false;

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];   // lower left
                } else {
                    nums[i + 1] = nums[i];   // raise right
                }
            }
        }

        return true;
    }
}

// [3,4,2,3]

// is 3< 4 yes 
// is 4<2 no count ++;
//check is i here 0 no its 1 so we check is i-1 <= i+1 if so we know that left side has less than element so we change the value of the as the next element , cause if the previous was greater we would need to change it to that to make the next element fit 
//.   i
// [3,4,2,3] here 3 > 2 if we change 4 to 3 [3,3,2,3] but here there will be other that would be less than 
// but if we do 4 to 2 

// ts problem sucks fck it boi 

