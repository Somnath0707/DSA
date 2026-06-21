class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int arr[] = new int[100001]; 

        for(int n : costs){
            arr[n]++;
        } 
        int temp = 0; 
        int count = 0 ; 
        ArrayList<Integer> list = new ArrayList<>(); 
        
        for(int i = 1 ; i < 100001; i++){
                while(arr[i] != 0 ){
                    // System.out.println(temp); 
                    temp += i ; 

                    // System.out.println("After adding : " + temp); 
                    if(temp > coins) break;
                    if(temp <= coins){
                        // System.out.println(temp + " < " + coins); 
                        count++; 
                        arr[i]--;
                    }
                }
                if(temp > coins) break;
        }

        return count; 
    }
}