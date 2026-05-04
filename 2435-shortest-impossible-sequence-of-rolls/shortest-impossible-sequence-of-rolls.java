class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> set = new HashSet<>();
        int layers = 1;

        for(int x : rolls){
            set.add(x);

            if(set.size() == k){
                layers++;
                set.clear();
            }
        }

        return layers;
    }
}