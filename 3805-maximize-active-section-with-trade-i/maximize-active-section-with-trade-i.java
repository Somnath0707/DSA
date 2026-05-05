class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String temp  = "1" + s + "1";
        int m = temp.length(); 

        //prefixZero
        //pOne
        // sZero
        //sONe
        int n = s.length();
        int prefixZero[] = new int[n];
        int prefixOne[] = new int[n];
        int suffixOne[] = new int[n]; 
        int suffixZero[] = new int[n];
        if(s.charAt(0) == '0'){
            prefixZero[0] = 1; 
            prefixOne[0] = 0 ; 
        }else{
            prefixZero[0] = 0 ; 
            prefixOne[0] = 1;
        }

        for(int i = 1 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch =='0'){
                prefixZero[i] = prefixZero[i-1] + 1; 
                prefixOne[i] = 0 ; 
            }else{
                prefixZero[i] = 0 ; 
                prefixOne[i] = prefixOne[i-1] + 1; 
            }
        }
        // count one 
        int ones = 0 ; 
        for(char ch : s.toCharArray()){
            if(ch == '1') ones++;
        }

        if(s.charAt(n-1) == '0'){
            suffixZero[n-1] = 1; 
            suffixOne[n-1] = 0 ; 
        }else{
            suffixZero[n-1] = 0 ; 
            suffixOne[n-1] = 1;
        }


        for(int i = n - 2; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(ch =='0'){
                suffixZero[i] = suffixZero[i+1] + 1; 
                suffixOne[i] = 0 ; 
            }else{
                suffixZero[i] = 0 ; 
                suffixOne[i] = suffixOne[i+1] + 1; 
            }
        }

        int ans = ones ; 
        // 0111110

        for(int i = 1 ; i < m-1 ; i++){
            if(temp.charAt(i) == '1' && temp.charAt(i-1) == '0'){

                int si = i - 1; // map to s
                if(si < 0 || si >= n) continue;
                int lenOne = suffixOne[si]; // length of 1 block
                int rightEnd = si + lenOne; // index in s

                if(rightEnd < n && s.charAt(rightEnd) == '0'){
                    int leftZero = prefixZero[si - 1 >= 0 ? si - 1 : 0];
                    if(si - 1 < 0) leftZero = 0;
                    int rightZero = suffixZero[rightEnd];
                    ans = Math.max(ans, ones + leftZero + rightZero);
                }
            }
        }

        return ans; 
    }
}