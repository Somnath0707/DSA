class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks , (a,b)->Integer.compare(a[1]-a[0] , b[1] - b[0]));
        int ans = tasks[tasks.length-1][1];
        int diff = tasks[tasks.length-1][1] - tasks[tasks.length-1][0];

        for(int i =tasks.length - 2 ; i>= 0 ; i--){

            if(tasks[i][1]>diff){
                ans += tasks[i][1]-diff;
                diff= tasks[i][1] - tasks[i][0];
            }else {
                diff = diff - tasks[i][0];
            }
        }
        return ans;
    }
}