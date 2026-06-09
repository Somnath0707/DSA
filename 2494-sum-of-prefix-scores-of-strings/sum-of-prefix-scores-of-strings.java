class Trie{
    static class Node{
        Node child[] ; 
        boolean isEnd ; 
        int occ ; 
        
        Node(){
            child = new Node[26]; 
            occ = 0 ; 
            isEnd = false; 
        }
    }

    Node root ; 
    public Trie(){
        root = new Node(); 
    }

    public void insert(String str ){
        Node node = root; 

        for(char ch : str.toCharArray()){
            int ind = ch - 'a';

            if(node.child[ind] == null){
                node.child[ind] = new Node();
            }
            node = node.child[ind];
            node.occ++; 
        }

        node.isEnd = true; 
    }

    public int search(String str){
        Node node = root; 
        int ans = 0 ; 
        for(char ch : str.toCharArray()){
            int ind = ch -'a';

            if(node.child[ind] == null){
                return ans ; 
            }

            node = node.child[ind];
            ans += node.occ; 
        }

        return ans; 
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        // trie
        // make trie for this complte with the total of the prefix or the occurence of that in each node 
        Trie tr = new Trie();

        for(String str : words){
            tr.insert(str);
        }

        List<Integer> list = new ArrayList<>();

        for(String str : words){
            list.add(tr.search(str));
        }

        int ans[] = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}