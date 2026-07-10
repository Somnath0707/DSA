class Solution {
    public int getLastMoment(int n, int[] l, int[] r) {
        // we have a wooden plan of the length n unit 
        // some ants are walking on th plank each ant move with spped of q unit per secon 
        // some ants move to the left the other move to rigght

        // when two ants moving in two diff dir meet at some point they chnage their dir and cotinue moving again 
        // assuming changing dir does not tak any additional time 

        // when an ant reaches one end of the plank at a time t it falls out of the plank 

        // return moment when the last ant falls down 

        //1 _ _ _ _2 3

        // return 4; 
        
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b)->b-a);
        int len = l.length; 
        int m = r.length;
        for(int i = 0 ; i < len ; i++){
            left.offer(l[i]);
        }
        for(int i = 0 ; i < m ; i++){
            right.offer(r[i]);
        }

        int ans = 0 ; 

        while(!left.isEmpty() && !right.isEmpty()){
            int leftVal = left.poll(); 
            int rightVal = right.poll(); 
            if(leftVal > rightVal || rightVal > leftVal){
                ans = Math.max(ans, n - rightVal );
                ans = Math.max(ans ,leftVal);
                continue; 
            }
            // int temp = n-rightVal+1 + ((rightVal - leftVal) / 2);
            // int temp2 = leftVal + ((rightVal - leftVal) / 2);
            // ans = Math.max(ans , temp);
            // ans = Math.max(ans , temp2);
            // }
        }
        while(!right.isEmpty())
        ans = Math.max(ans , n - right.poll());
        while(!left.isEmpty()){
            ans = Math.max(ans , left.poll());
        }

        return ans; 


    }
}

//