class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //[3,8,-10,23,19,-4,-14,27]->[-14,-10,-4,3,8,19,23,27]
        //check the first two and put them in list 
        // make there dif as the min 
        // if new pair come with same diff add them to least 
        // if the new diff is less remove all the previous and add this and set this as new min diff
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        
        
        for(int i = 0; i < arr.length - 1; i++){
            int diff = Math.abs(arr[i] - arr[i+1]);

            if(diff<min){
                result.clear();
                min = diff ; 
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
            else if(diff == min){
                result.add(Arrays.asList(arr[i], arr[i +1]));
            }
        }
        
        return result; 
    }
}