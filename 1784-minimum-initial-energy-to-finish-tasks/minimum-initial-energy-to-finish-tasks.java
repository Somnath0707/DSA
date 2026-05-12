class Solution {
    public int minimumEffort(int[][] tasks) {
        int start = 0;
        int end = 0;
        for(int[] task: tasks){
            start += task[0];
            end += task[1];
        }
        int res = Integer.MAX_VALUE;
        Arrays.sort(tasks, (a, b) -> { return (b[1] - b[0]) - (a[1] - a[0]);});
        System.out.println(Arrays.deepToString(tasks));
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isValid(tasks, mid)){
                res = Math.min(res,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    boolean isValid(int[][] tasks, int num){
        for(int[] task: tasks){
            if(num<task[1]){
                return false;
            }
            num -= task[0];
        }
        return true;
    }
}