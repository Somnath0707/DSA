class Solution {
    public int[] diStringMatch(String s) {
        int left = 0; 
        int right = s.length() ; 
        int arr[] = new int [s.length() + 1];

        int index = 0;
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == 'I'){
                arr[index] = left;
                index++;
                left ++; 
            }
            else{
                arr[index]=right;
                right--;
                index ++;
            }
        }
        arr[index] = right ; 
        return arr;
        
    }
}