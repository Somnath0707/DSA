class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        

        int n = status.length;
        // We only add the boxes that we could open 
        Queue<Integer> box = new LinkedList<>();

        // Add the aval keys in the set 
        Set<Integer> key = new HashSet<>();
        Set<Integer> lockedBox = new HashSet<>();
        Set<Integer> opened = new HashSet<>();

        for(int i= 0 ; i < n ; i++){
            if(status[i] == 1 ){
                key.add(i);
            }
        }

        // Add the inital boxes in the queue
        for(int i = 0 ; i < initialBoxes.length ; i++){
            box.add(initialBoxes[i]);
        }

        int sum = 0 ; 

        
        // till we dont check all the boxes 
        while(!box.isEmpty()){
            
            // Check for the curr box 
            int currBox = box.poll();

            if(opened.contains(currBox)) continue;

            if(key.contains(currBox)){
                sum += candies[currBox];
                opened.add(currBox);

                int inBox[] = containedBoxes[currBox];
                for(int i = 0 ; i < inBox.length ; i++){
                    box.add(inBox[i]);
                }

                int foundKey [] = keys[currBox];
                for(int i = 0 ; i < foundKey.length ; i++){
                    key.add(foundKey[i]);
                    if(lockedBox.contains(foundKey[i]) && !opened.contains(foundKey[i])){
                        box.add(foundKey[i]);
                    }
                }
            }else{
                lockedBox.add(currBox);
            }


            // check if the this box has key
        }

        return sum ; 


    }
}