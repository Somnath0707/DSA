class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // If I were alice I would try to reduce the bobs chances of wining and how will i do that if i already know which stone has which value i would take a stone that is most valuable to the bob instead of which is most valuable to me as the nummber is pos i might get the lowest from my bunch but he will never get the higest too lmao so my chnace would increase 

        // but just the first example dis proves it lmao like 1,3 and 2,1 here most valuble for bob is 2 so if alice took stone 0 then alice 1 and then bob will get 1 so draw but alice 

        // or even further now at each point ask what will hurt the bobs chances most taking his max or taking my max here 1,2 and 3,1 if alice take it hurt bob 3 points but if we take 1 we gain only two point so which is better 3 points take that and our become 1 then 2  and 1 bob as no chooice but to take 1 its a draw 

        // 2 4 3 and 1 6 7 which is choice alice can make take our 3 and cost him 7 both are same so we take 3 and remove the 7 now 2 4 and 1 6 which will bob take our he can gain 6 max or he can reomve 4 lmao just take 6 both are same so 6 and 3 now alice last stone 2 so 5 and 6 bob wins no other way 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        // Set<Integer> removed = new HashSet<>();
        int n = aliceValues.length;
        for(int i = 0 ; i < n ; i++){
            int sum = aliceValues[i] + bobValues[i];
            pq.offer(new int[]{i , sum});
        }

        int bob = 0 ; 
        int alice = 0 ; 
        int turn = 0 ; 
        while(!pq.isEmpty()){
            if(turn == 0 ){
                int curr[] = pq.poll();
                int ind = curr[0]; 
                alice += aliceValues[ind]; 
                turn = 1; 
            }
            else{
                int curr[] = pq.poll();
                int ind = curr[0]; 
                bob += bobValues[ind]; 
                turn = 0; 
            }
        }
        if(alice > bob) return 1 ; 
        else if(bob > alice) return -1; 
        return 0 ; 
    }
}