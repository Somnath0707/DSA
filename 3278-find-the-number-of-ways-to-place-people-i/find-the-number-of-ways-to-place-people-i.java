class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points , (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0] , b[0]);
            return Integer.compare(b[1] , a[1]);
        });

        int count =0  ; 
        int n = points.length ; 
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                // the we check 
                int x1 = points[i][0]; 
                // the one we arechecking 
                int x2 = points[j][0] ; 

                int y1 = points[i][1]; 
                int y2 = points[j][1]; 
                if(x1 >= x2 && y1 <= y2){
                    count++; 
                    for(int k = 0 ; k < n ; k++){

                        if(k == i || k == j) continue;
                        int newX = points[k][0]; 
                        int newY = points[k][1]; 

                        if((newX < x2 || newX >x1) || (newY > y2 || newY < y1) ){
                            continue; 
                        }
                        else {
                            count--; 
                            break;
                        }
                    }
                }
            }
        }
        return count; 
    }
}