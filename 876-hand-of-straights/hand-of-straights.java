class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Create a treeemap to store the elements with freq
        TreeMap<Integer,Integer> map = new TreeMap<>();

        // Put the value in tree map along with frequency 
        for(int h : hand ){
            map.put(h,map.getOrDefault(h,0)+1);
        }

        // now we have the map wit its frequency 

        while(!map.isEmpty()){
            // always get first key i.e. the lowest value
           int first = map.firstKey();

            // Loop till k(groupSize) so we only keep the k elements in the group 
            for(int i =0 ; i < groupSize ;i++){
                // we need currValue shoud be first + i i.e. 1+0,1+2,1+3 till the k
                int currValue = first + i ; 

                // If map does not contains the curr we return fasle 
                if(!map.containsKey(currValue)) return false; 

                // If the map contains the curr then decrease the frequ fromthe map
                if(map.containsKey(currValue)){
                    map.put(currValue,map.get(currValue)-1);
                }

                //if frequency becomes 0 remove that sucker from the map
                if(map.get(currValue) == 0){
                    map.remove(currValue);
                }
                
            }
        }

        return true; 
    }
}








// Intution : 
        // 1. Make a tree map (hashmap but sorted) 
        // 2. put the value along with frequency
        // 3. Now traverse the tree map from the first value 
        // General Idea here will be remove if we get an element we reduce the frequecy till 0
        // If the freq reaches 0 remove from the map we go till all are removed
        // 4. Traverese till the map become empty
        // 5. In loop check first element in map 
        // 6. Run a loop from 0 till k group size to fill onlly k element s
        // 7.If map contains the first + i elements ex(first 1 + 0 =1 , 1+1 =2 , 1+2 = 3)
        // here our i will keep increaing with loop 
        // 8. Now if the elemnts like first +i exist in the map decerease the frequency 
        // 9. If freq reaches 0 remove from the map 
        // 10. If the value is not in the map return false