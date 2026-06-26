class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int arr[][] = new int[n][2]; 

        for(int i =0 ; i < n ; i++){
            arr[i][0] = capital[i]; 
            arr[i][1] = profits[i]; 
        }
        Arrays.sort(arr , (a,b)->a[0]-b[0]) ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        int ind = 0 ; 
        int count = 0; 
        while(count < k ){
            for(int i = ind ; i < n ; i++){
                if(arr[i][0] <= w){
                    pq.offer(new int[]{arr[i][0] , arr[i][1]});
                    if(i == n-1 ){
                        ind = n+1 ; 
                        break;
                        }
                    // System.out.println(pq.peek()[0] + " " + pq.peek()[1]);
                }
                else{
                    ind = i ; 
                    break;
                }
            }
            // System.out.println(w + " the first " + ind );
            if(!pq.isEmpty()){
                w += pq.poll()[1]; 
                count++; 

            }
            else break ; 
        }

        return w; 
    }
}