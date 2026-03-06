class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
                    if(a[0] == b[0])
                        return b[1] - a[1];
                    return a[0] - b[0];
                });

        List<Integer> tails = new ArrayList<>();
        for(int[] x : envelopes){
            int h = x[1] ;// height as for the x ->[width , height ]

            int l = 0 , r = tails.size();

            while( l < r ) {
                int mid = (l + r) / 2 ;

                if(tails.get(mid) < h){
                    l = mid+1;
                }
                else {
                    r = mid ;
                }
            }

            if(l == tails.size()){
                tails.add(h);
            }
            else {
                tails.set(l , h );
            }

        }

        return tails.size();
    }
}