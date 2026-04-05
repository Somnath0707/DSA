class Solution {
    public List<Integer> findGoodIntegers(int n) {

        Map<Integer ,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        // max value of n = 100000000 so the a and b could go max to 1000 only 
            // so the limit becomes 1000 because 1000^3 =1,00,00,00,000 
        int limit = (int) Math.pow(n , 1.0/3.0)+1;


        for(int a = 1 ; a <= limit ; a++){
            long aCube =(long) a * a * a ; 
            if(aCube > n ) break ; 

            for(int b = a ; b<= limit; b++){
                long sum = aCube + (long)b * b * b ; 

                if(sum <= n ){
                    map.put((int)sum , map.getOrDefault((int)sum , 0 ) + 1 ) ; 
                }else{
                    break;
                }
            }
        }

        for(Map.Entry<Integer , Integer > entry : map.entrySet()){
            if(entry.getValue() >= 2 ) {
                res.add(entry.getKey());
            }
        }

        Collections.sort(res);
        return res; 
    }
}