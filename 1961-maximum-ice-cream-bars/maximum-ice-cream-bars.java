class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int arr[] = new int[100001]; 

        for(int n : costs){
            arr[n]++;
        } 

        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = 0 ; i < 100001; i++){
            if(arr[i] != 0) {
                while(arr[i] != 0 ){
                    list.add(i);
                    arr[i]--;
                }
            }
        }
        int count =0 ; 
        int temp = 0 ; 
        for(int i = 0 ; i <list.size() ; i++){
            temp+= list.get(i);
            if(temp <= coins) count++; 
            else break ; 
        }

        return count; 
    }
}