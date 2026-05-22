class SegmentTree {
    int tree[];  
    int n ; 

    SegmentTree(int arr[]){
        n = arr.length ; 
        tree = new int[4*n];
        build(arr , 0 , 0 , n-1 );
    }

    public void build(int arr[] , int i, int left , int right ){
        // leaf node
        if(left == right){
            tree[i] = arr[left];// can also do the right 
            return ; 
        }

        int mid = left + (right - left ) /2; 
        
        build(arr , 2 * i + 1 , left , mid);
        build(arr , 2 * i + 2 , mid + 1 , right);

        tree[i] = Math.max(tree[2 * i + 1 ] , tree[2* i + 2]);
    }

    public int query(int i , int ql , int qr , int left , int right){
        
        // if no over lap 
        if(ql > right || qr < left ){
            return Integer.MIN_VALUE; 
        }

        // over lap 
        if(ql<= left && qr >= right){
            return tree[i];
        }

        int mid = left + (right - left) / 2 ;

        int leftRes = query(2* i + 1 , ql , qr , left , mid);
        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right);

        return Math.max(leftRes , rightRes);
    }
}

class Solution {
    public int countLocalMaximums(int[][] matrix) {
        
        int n = matrix.length; 
        int m = matrix[0].length;
        SegmentTree st[] = new SegmentTree[n];

        for(int i = 0 ; i < n ; i++){
            st[i] = new SegmentTree(matrix[i]);
        }

        int count = 0 ; 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int curr = matrix[i][j];
                if(curr == 0 ) continue;
                // Check wheater our select is biggest in the locality 
                boolean check = true; 

                // query for the top to down 
                int top = Math.max(0 , i - curr); // so no out of range 
                int bottom = Math.min(n-1 , i+curr);


                // left to right 
                int left = Math.max(0 , j-curr);
                int right = Math.min(m-1 , j+curr);

                for(int k = top ; k <= bottom ; k++){

                    int l = left ; 
                    int r = right; 
                    // if corner skip 
                    if(Math.abs(k - i) == curr ) {

                        if(j-curr >= 0){
                            l++;
                        }
                        if(j+curr < m ){
                            r--;
                        }
                    }

                    // we go till the last column so m-1 
                    int max = st[k].query(0 , l , r , 0 , m-1 );

                    if(max > curr){
                        check = false; 
                        break;
                    }
                }
                if(check){
                    count++;
                }
                
            }
        }
        return count; 
    }
}