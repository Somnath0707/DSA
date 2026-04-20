class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //check if the first of any has in the target if it is compare it update it no check for the second element then check for the next element 
        

        // find first second and 3rd element so that it is lower than target and one that is equal < to the target if we found that we can compare it and make the smller one toward our target and move forward 
        // How do we do that 

        boolean x = false , y = false , z = false;

        for(int t[] : triplets){

            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;


            if(t[0] == target[0]) x = true; 
            if(t[1] == target[1]) y = true;
            if(t[2] == target[2]) z = true;
        }

        return x && y && z;
    }
}