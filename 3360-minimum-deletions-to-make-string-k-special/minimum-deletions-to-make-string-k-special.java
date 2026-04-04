class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character , Integer > map = new HashMap<>();

        for(char ch : word.toCharArray()){
            map.put(ch , map.getOrDefault( ch , 0 ) + 1);
        }

        int [] arr = new int[map.size()];
        int indx = 0; 
        for(Map.Entry<Character , Integer> entry : map.entrySet()){
            arr[indx++] = entry.getValue();
        }
        int count = Integer.MAX_VALUE ; 
        for(int i = 0 ; i < arr.length ; i++){
            int base = arr[i];
            int del = 0 ; 

            for(int j = 0 ; j < arr.length ; j++){
                if(arr[j] < base ){
                    del += arr[j];
                }
                else if(arr[j] > base + k){
                    del += arr[j] - (base + k) ;
                }
            }
            count = Math.min(del , count);
        }
        return count ;
    }
}

// 2 3 6 k = 1 

// a = 1 
// b = 2 
// c = 3 
// d = 8
// 1- 8 -2 = 5
// 2 + 2 - 8 = 4

// if(k+ch[freq] >= k+ch[freq] - highestfreq) highest freq -= k+ch[freq] - highestfreq

// c = 
// b = 2 
// c = 2


// 0 + 1 - 4 = 3
// 0 + 2 - 4 = 2 