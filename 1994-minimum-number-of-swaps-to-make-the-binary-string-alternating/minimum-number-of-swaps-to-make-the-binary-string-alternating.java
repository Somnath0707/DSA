class Solution {
    public int minSwaps(String s) {

        int startWithZero = getSwaps(s, '0');
        int startWithOne = getSwaps(s, '1');
        
        if (startWithZero == -1 && startWithOne == -1) return -1;
        if (startWithZero == -1) return startWithOne;
        if (startWithOne == -1) return startWithZero;
        
        return Math.min(startWithZero, startWithOne);
    }

    private int getSwaps(String s, char expected) {
        int swapOne = 0; 
        int swapZero = 0; 
        int ans = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            

            if (curr != expected) {

                if (curr == '1') {
                    if (swapZero == 0) {
                        ans++;
                        swapOne++; 
                    } else {
                        swapZero--; 
                    }
                } else { // curr == '0'
                    if (swapOne == 0) {
                        ans++; 
                        swapZero++; 
                    } else {
                        swapOne--; 
                    }
                }
            }

            expected = (expected == '1') ? '0' : '1';
        }
        

        if (swapZero == 0 && swapOne == 0) return ans; 
        
        return -1; 
    }
}