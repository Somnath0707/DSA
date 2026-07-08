class Solution {
    public int minimumBuckets(String s) {
        char arr[] = new char[s.length()]; 
        int ind = 0 ; 
        for(char ch : s.toCharArray()){
            arr[ind++] = ch ; 
       }

    //    if(n == 1 ) return -1; 

       int n = s.length(); 
       int count = 0 ; 
       for(int i = 0 ; i< arr.length ; i++){ 
        char ch = s.charAt(i); 
        if(ch == 'H' ){
            if(i-1 >=0 && arr[i-1] == '1'){
                continue; 
            }
            if(i+1 <= n-1 && arr[i+1] != 'H'){
                arr[i+1] = '1';
            }
            else if( i-1 >= 0 && arr[i-1] != 'H'){
                arr[i-1] = 1 ; 
            }else{
                return -1; 
            }
            count++; 
        }
       }
        // if(count == 0 ) return -
       return count;
    }
}

// ..h.h.hh..h.h