class Solution {

    public int numberOfWeakCharacters(int[][] nums) {
        // [[1,5],[10,4],[4,3]] -> 1,5 ; 4,3 ; 10,4

        Arrays.sort(nums , (a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            return b [1] - a[1];
        });
        Stack<Integer> stA = new Stack<>();
        Stack<Integer> stB = new Stack<>();
        int count = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            int curr[] = nums[i];
            int att = curr[0];
            int def = curr[1];

            if(stA.isEmpty()){
                stA.push(att);
                stB.push(def);
            }
            
            else if(!stA.isEmpty()){
               if(stA.peek() >= att || stB.peek() >= def){
                stA.push(att);
                stB.push(def);
               }
               else {
                    while(!stA.isEmpty() && (stA.peek() < att && stB.peek() < def ) ){
                        stA.pop();
                        stB.pop();
                        count++;
                    }
                    stA.push(att);
                    stB.push(def);
               }
            }

        }

        return count;
        
    }
}