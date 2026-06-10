class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length(); 
        int arr[] = new int[n];
        int diff[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            int num = s.charAt(i) - 'a';
            arr[i] = num; 
        }

        for(int q[] : shifts){
            int l = q[0]; 
            int r = q[1]; 
            int dir = q[2]; 

            if(dir == 0){
                diff[l] -= 1; 
                if(r+1 < n) diff[r+1] += 1; 
            }else{
                diff[l] += 1 ; 
                if(r+1 < n) diff[r+1] -=1;
            }
            
        }

        int nums[] = new int[n];

        nums[0] = diff[0];

        for(int i = 1 ; i < n ; i++){
            nums[i] = nums[i-1] + diff[i]; 
        }

        for(int i = 0 ; i < n ; i++){
            arr[i] =(( arr[i] + nums[i]) % 26  + 26 )% 26;
            System.out.println(arr[i]);
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char ch = (char)('a' + arr[i]); 

            str.append(ch);
        }

        return str.toString();
    }
}