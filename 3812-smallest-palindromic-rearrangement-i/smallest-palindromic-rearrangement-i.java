class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26]; 

        for(int i = 0 ; i < s.length() ; i++){
            int val = s.charAt(i) -'a';
            arr[val]++; 
        }
        String str = ""; 
        int oddAt = -1; 
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 1){
                for(int j = 0 ; j < arr[i]/2 ; j++){
                    // arr[i]-=2;
                    str = str + (char)('a' + i); 
                }
                arr[i] %= 2;
            }
        }

        String temp = new StringBuilder(str).reverse().toString(); 

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 1){
                for(int j = 0 ; j < arr[i] ; j++){
                    arr[i]--; 
                    str = str + (char)('a' + i);
                }
            }
        }
        

        return str + temp; 

        // return "";

    }
}