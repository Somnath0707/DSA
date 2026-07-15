class Solution {
    public  void swap(int nums[] , int a , int b){
        int temp = nums[a]; 
        nums[a] = nums[b]; 
        nums[b] = temp; 
        return ; 
    }
    public int minSwapsCouples(int[] row) {
        // return 1;

        // 0->2->1->3
        int n = row.length ; 
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i+=2){
            int curr = row[i]; 
            int next = 0; 
            if(curr %2 == 0){
                next = curr+1; 
                if(i+1 < n && row[i+1] == next) continue;
                else{
                    for(int j = i+1 ; j < n ; j++){
                        int temp = row[j]; 
                        if(temp == next){
                            swap(row , i+1 , j);
                            ans++; 
                            break;
                        }
                    }
                } 
            }else if(curr % 2 != 0 ){
                next = curr-1; 
                if(i+1 < n && row[i+1] == next )continue; 
                else {
                    for(int j = i+1 ; j < n ; j++){
                        int temp = row[j]; 
                        if(temp == next){
                            swap(row , i+1 , j);
                            ans++; 
                            break;
                        }
                    }
                }
            }
        } 
        return ans; 
    }
}