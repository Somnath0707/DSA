class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        /// fruits are aval at some pos on infinite x axis 
        // we have 2d array fruits where fruits[i] = pos , amount 

        // depicts amount fruits at position 

        // fuits are already sorted by pos in ascending order and each position is unique 



        // You also given an integer start pos and an niteger k 
        // initially you are at the position start pos from any pos you can either walk to the left or right 
        // It takes one step to move one unit on the x axis and you can walk at most k steps in total 


        // So we can do prefix sum for the number before this and then prefix sum after give pos then we do binary search on number k such that 2 , 0 or 1 , 0 or 0 , 1 
        // such like for 4: 0 ,4 or 4, 0 or 2 ,1 or 1 , 2 like that get the value at that prefix sum for each 

        // [[2,8],[6,3],[8,6]], ->  8 8 8 8 11 11 17 17 17
        int max = 0 ; 
        Map<Integer,Integer> map = new HashMap<>(); 
        for(int i = 0 ;i < fruits.length ; i++){
            int num = fruits[i][0]; 
            int val = fruits[i][1]; 
            map.put(num , val);
            max = Math.max(max , num);
        }

        int arr[] = new int[200002];

        if(map.containsKey(0)){
            arr[0] = map.get(0);
        }
        int n = arr.length ; 
        for(int i = 1 ; i < n ; i++){
            int newVal = 0 ; 
            if(map.containsKey(i)){
                 newVal = map.get(i);
            }
            arr[i] = arr[i-1]  + newVal ; 
        }

        int ans = 0 ; 

        

        for(int i = 0 ; i <= k/2 ; i++){
            int curr = i ; 
            if (k - 2*i < 0) break;
            int left = startPos - i ; 
            int right = startPos + (k - curr * 2 ); 
            int calc = 0 ; 
            left = Math.max(0, left);
            right = Math.min(200001, right); 
            if( left == 0 ) calc = arr[right];
            else    
            calc =  arr[right] - arr[left-1]; 

            ans = Math.max(ans , calc);
        }

        for(int i = 0 ; i <= k/2 ; i++){
            int curr = i ; 
            if (k - 2*i < 0) break;
            int right = startPos + i ; 
            int left = startPos - (k - curr * 2); 
            left = Math.max(0, left);
            right = Math.min(200001, right);

            int calc = 0 ; 
            if( left == 0 ) calc = arr[right];
            else 
            calc = arr[right] - arr[left-1];
            ans = Math.max(ans , calc);
        }

        return ans ; 
    }
}