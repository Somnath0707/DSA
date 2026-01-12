class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Children greed (g):  [7, 1, 5, 3, 9, 2]
        //Cookies size (s):   [1, 2, 8, 3, 6, 4]



        Arrays.sort(g);
        Arrays.sort(s);

        // After sorting 
        //g = [1, 2, 3, 5, 7, 9]
        //     l
        //s = [1, 2, 3, 4, 6, 8]
        //     r




        int l = 0;
        int r = 0 ; 

        int m = g.length;
        int n = s.length;
        int count = 0 ; 

        while(l < m && r < n){
        //g = [1, 2, 3, 5, 7, 9]
        //     l
        //s = [1, 2, 3, 4, 6, 8]
        //     r
            if(s[r]>=g[l]){
                count ++;
                r++; 
                l++;
            }
         //g = [1, 2, 3, 5, 7, 9]
        //               l
        //s = [1, 2, 3, 4, 6, 8]
        //              r
            
            
            else{
            r++;
            }
        //g = [1, 2, 3, 5, 7, 9]
        //              l
        //s = [1, 2, 3, 4, 6, 8]
        //                 r


        //g = [1, 2, 3, 5, 7, 9]
        //                 l
        //s = [1, 2, 3, 4, 6, 8]
        //                    r


         //g = [1, 2, 3, 5, 7, 9]
        //                     l
        //s = [1, 2, 3, 4, 6, 8]
        //                        r
        }
        return count ; 
        
    }
}



// | Step | l (child) | g[l] | r (cookie) | s[r] | Decision | Action               | Count |
// | ---- | --------- | ---- | ---------- | ---- | -------- | -------------------- | ----- |
// | 1    | 0         | 1    | 0          | 1    | 1 ≥ 1 ✅  | assign → l++, r++    | 1     |
// | 2    | 1         | 2    | 1          | 2    | 2 ≥ 2 ✅  | assign → l++, r++    | 2     |
// | 3    | 2         | 3    | 2          | 3    | 3 ≥ 3 ✅  | assign → l++, r++    | 3     |
// | 4    | 3         | 5    | 3          | 4    | 4 < 5 ❌  | discard cookie → r++ | 3     |
// | 5    | 3         | 5    | 4          | 6    | 6 ≥ 5 ✅  | assign → l++, r++    | 4     |
// | 6    | 4         | 7    | 5          | 8    | 8 ≥ 7 ✅  | assign → l++, r++    | 5     |
// | ❌    | 5         | 9    | 6          | —    | r == n   | stop                 | 5     |
