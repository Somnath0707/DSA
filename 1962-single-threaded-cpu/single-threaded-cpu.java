class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int arr[][] = new int[n][3];
        for(int i = 0 ;  i < n ; i++){
            // enque time 
            arr[i][0] = tasks[i][0];
            // processing time 
            arr[i][1] = tasks[i][1];
            // index
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int ans[] = new int[tasks.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });

        int i = 0 , indx = 0 , time = 0 ; 


        while(i < n || !pq.isEmpty()){

            // If the pq is Empty and there is no task at time we jump to the time when the task starts
            if(pq.isEmpty() && time < arr[i][0]){
                time = arr[i][0];
            }

            //while the i < n and and number of process that are less than the curr time or eqal
            while(i < n && time >= arr[i][0]){
                pq.offer(arr[i]);
                i++;
            }
            int top[] = pq.poll();
            int processTime = top[1];
            int currInd = top[2];

            time += processTime;
            ans[indx++] = currInd;
        }
                
        return ans;
    }
}


//[[1,2],[2,4],[3,2],[4,1]] make a heap that take the value by the low finish time 
// for 1 we have wait 2 sec till then we have the option to run the [2,4][3,2] any one we choose the one with the minimum execution time so first 0 the task then 2 nd then while it process the time would be 3 + 2 = 5 i.e all of them are in the heap take the lowest 