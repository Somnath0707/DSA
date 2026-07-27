class Solution {
    public boolean  check(int []nums , int arr[] , int cap , int mid){
        int count = 0; 
        int i = 0 ; 
        int j = 0 ; 

        while(i < nums.length && j < arr.length){
            if(mid <= arr[j] && mid <= nums[i] ){
                return true; 
            }
            else if(arr[j] <= nums[i]){
                j++; 
                count++; 
            }
            // else if(nums[i] < arr[j]){
            //     i++;
            //     count = 0; 
            // }
            else {
                i++;
                // j++; 
                count = 0 ; 
            }
            if(count == cap ){
                count = 0 ; 
                i++; 
            }
        }
        while (i < nums.length) {
            if(mid <= nums[i])
            return true;
            i++;
        }
        return false; 
    }
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses); 
        Arrays.sort(passengers);

        int left = 1; 
        int right = buses[buses.length - 1]; 
        int ans = 0 ; 

        Set<Integer> set = new HashSet<>(); 
        for(int i =0 ; i < passengers.length ; i++){
            set.add(passengers[i]);
        }
        while(left <= right){
            int mid = left + (right - left ) / 2; 

            if(check(buses , passengers , capacity , mid)){
                ans = mid; 
                left = mid+1 ; 
            }
            else{
                right = mid-1; 
            }
        }

        while(set.contains(ans)){
            ans--; 
        }
        return ans; 
    }
}