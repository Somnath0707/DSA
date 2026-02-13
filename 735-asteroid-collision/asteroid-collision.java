class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int curr : asteroids){

            if(curr >0){
                stack.push(curr);
            }

            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(curr)){
                    stack.pop();
                }

            
                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(curr);
                }

                if(stack.peek() == -curr){
                stack.pop();
                }
            }
        }
        int[] result = new int[stack.size()];

        int i = stack.size()-1;
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }
        return result;
    }
}