class Solution {
    public int minGenerations(int[][] points, int[] target) {
        // Make a set add the curr if there is any which has target return 0 ; 
        // make a new combination and and add that too the set too 
        // make a list and add the curr points and as time goes check neew and if it is not in set then add those in the new list keep on check till when al fo these can go any low because taking avg again and again will make it so low that i will beceome low at some point unitl no new element is added to the list 

        List<int[]> newPoint = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String targetKey = target[0] + "#" + target[1] + "#" + target[2];

        for(int i = 0 ; i < points.length ; i++){
            int temp[] = new int[3];
            for(int j = 0 ; j < points[0].length ; j++){
                temp[j] = points[i][j];
            }
            if(Arrays.equals(target, temp)) return 0 ; 
            String key = temp[0] + "#" + temp[1] + "#" + temp[2];
            if(!set.contains(key)){
                set.add(key);
                newPoint.add(temp);
            }
        }

        int count = 0 ; 
        while(true){
            List<int[]> newGen = new ArrayList<>();
            boolean added = false;
            for(int i = 0 ; i < newPoint.size() ; i++){
                for(int j = 0 ; j < newPoint.size() ; j++){
                    if(i == j ) continue;
                    
                    int a[] = newPoint.get(i);
                    int b[] = newPoint.get(j);

                    int x = (a[0] + b[0]) / 2; 
                    int y = (a[1] + b[1]) / 2 ; 
                    int z = (a[2] + b[2] ) / 2; 

                    String key = x + "#" + y + "#" + z ; 
                    if(key.equals(targetKey)) return count+1; 
                    if(!set.contains(key)){
                        set.add(key);
                        added = true; 
                        newGen.add(new int[] {x , y , z });
                    }
                }
            }
            count++;
            for(int i = 0 ; i < newGen.size() ; i++){
                newPoint.add(newGen.get(i));
            }
            if(!added){
                break;
            }
        }
    return - 1; 
    }
}