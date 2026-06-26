class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // we have n jobs and m worker we are given three array diff , profit and worker 

        // diff and profit are the dif an dthe profit of th ith job 
        // worker is the ability 

        // We need something that chould group diff and profit together 

        // we can do like for the curr diff what is most profti one can earn i.e 

        Map<Integer,Integer> map = new HashMap<>();  

        for(int i = 0; i < difficulty.length ; i++){
            int diff = difficulty[i];
            int prof = profit[i]; 
            if(map.containsKey(diff)){
                if(map.get(diff) > prof) continue; 
            }
            map.put(diff , prof);
        }
        int n = worker.length;  
        int max = 100000; 


        // System.out.println("before the worker");
        int arr[] = new int[max+1]; 
        for(int i = 1; i < arr.length ; i++){
            if(map.containsKey(i)){
                int num = map.get(i); 
                arr[i] = Math.max(arr[i-1] , num);
                // System.out.println(arr[i]);
            }else 
            arr[i] = arr[i-1];
            // System.out.println(arr[i]);
        }

        int ans =0 ; 
        for(int i = 0 ; i < n ; i++){
            int ind = worker[i]; 
            ans += arr[ind];
        }

        return ans; 
    }
}