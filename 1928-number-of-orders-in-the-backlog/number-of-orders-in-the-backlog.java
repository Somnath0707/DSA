class Solution {
    int MOD = 1000000007;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyMax = new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]> sellMin = new PriorityQueue<>((a,b) -> a[0]-b[0]); 

        for(int num[] : orders){
            int cost = num[0];
            int amount = num[1]; 
            int type = num[2]; 

            // buy 
            if(type == 0){
                while( !sellMin.isEmpty() && sellMin.peek()[0] <= cost && amount > 0 ){
                    int temp[] = sellMin.poll(); 
                    int matched = Math.min(amount , temp[1]);

                    amount-= matched;
                    temp[1]-=matched; 

                    if(temp[1] >0){
                        sellMin.offer(temp);
                }
                }

                if(amount > 0 ){
                    buyMax.offer(new int[]{cost , amount});
                }
            }

            if(type == 1){ 
                while(!buyMax.isEmpty() && buyMax.peek()[0] >= cost && amount > 0){
                    int temp[] = buyMax.poll(); 
                    int matched = Math.min(amount , temp[1]);

                    amount-= matched;
                    temp[1]-=matched; 

                    if(temp[1] >0){
                        buyMax.offer(temp);
                    }
                }

                if(amount > 0 ){
                    sellMin.offer(new int[]{cost , amount});
                }
            }
        }
        int ans = 0 ; 
        while(!buyMax.isEmpty()){
            int temp[] = buyMax.poll();
            ans = (ans + temp[1]) % MOD; 
        }

        while(!sellMin.isEmpty()){
            int temp[] = sellMin.poll();
            ans = (ans + temp[1]) % MOD; 
        }

        return ans ; 
    }
}