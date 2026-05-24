class Solution {
    public int furthestBuilding(int[] nums, int bricks, int ladders) {
        //. height brick and ladder 
        // we start from 0 and move next using the bricks or ladder
        // moving form one to next building 
        // if curr builder height >= next no brick or laddder we jump directlu 
        // if curr building height < next we can either use one ladder or h[i+1] -h[i]bricks 

        // return the furtheset building indexyou cn go if you use the given ladder and brick optimally 
        // smells dp but could be greddy observation too who knows 
        // first intution is for greedy is to make the optimal choice per local solution htat would be taking in considertaiton like for smaller jumps use the bricks and for larger jump we can use ladder so we dont waste the bricks 
        //constrints are pretty high 10^5 so its most prob not dp 
        // make a heap of the size of the ladder and then when we need them we will use so if the current number is in the heap we can use ladder there else we simply use the bricks 
        // where could this be an issue 

        // 8 , 5 , 15 , 2 , 16 -> ladder = 2 -> 15 and 16 
        //bricks = 10 , 
        // no we are on number 3 with 2 brick and 1 ladder 
        // now we are on index 3 we can go donw to 4th index 
        // no that diff is 15 we have 15 in heap and we have 1 ladder so we can jump
        // so current no becomes 5 and we have 2 bricks and 0 ladder 
        // next diff is 2 so we use remaining brick go to 6 and then 7th is less than curr so we go down now we have 0 bricks and 0 ladder so its game over 

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int i = 0;
        
        while(i < n -1){
            int curr = nums[i];
            int next = nums[i+1];
            int diff = next - curr;
            if(diff <= 0 ) {
                i++;
                continue;
            }

            if(ladders > 0){
                ladders--;
                pq.offer(diff);
                i++;
            }
            else {
                pq.offer(diff);
                bricks -= pq.poll();
                if(bricks < 0){
                    return i;
                }
                i++;
            }
        }
        return i ; 
    }
}
