class Solution {
    public int[] dailyTemperatures(int[] t) {

        // an array to store the index
        int[] day = new int [t.length];

        //Stack to store the index not the value the index
        Stack<Integer> stack = new Stack<>();

        // A loop to go through all the temperature 
        for(int i =0 ; i < t.length; i++){

            // A loop to check if the value of the index in stack is greater than the the index we are checking 
            while(!stack.isEmpty() && t[i]>t[stack.peek()]){
                // if the curr value we are check is greater than the element in stack we have found the higher temp 
                int indx = stack.pop(); // the index of the value in stack and the curr the index we are currently visting and there diff should be the answer 
                day[indx] = i - indx; // i will be higher cause we will be checking i ahead of the indx 
            }
            // if the stack is empty or the value is not we can add that to the stack 
            stack.push(i); 
        }

// return the days array 
    return day;
        
    }
}