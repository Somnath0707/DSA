class Trie{

    static class Node{
        Node child[];
        int val;

        boolean isEnd ; 

        public Node(){
            child = new Node[26];
            val = 0 ; 
            isEnd = false;
        }
    }

    Node root; 
    Trie(){
        root = new Node();
    }

    public void insert(String s , int val ){
        Node node = root; 

        for(char ch : s.toCharArray()){
            int indx = ch -'a';
            if(node.child[indx] == null){
                node.child[indx] = new Node();
                // node.val = val;
            }

            

            node = node.child[indx];
            // if(node.val != val ){
                System.out.println(node.val + " " + val + " " + node.val+val);
                node.val += val;
            // }
        }
        node.isEnd =true; 
    }

    public int search(String s){
        Node node = root; 

        for(char ch : s.toCharArray()){
            int indx = ch - 'a' ; 


            if(node.child[indx] == null){
                return 0;
            }
            node = node.child[indx];
            
        }
        return node.val;
    }
}
class MapSum {
    Trie trie ;
    HashMap<String,Integer> map; 
    public MapSum() {
        trie = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int newVal = 0 ;
        if(map.containsKey(key)){
            newVal = val - map.get(key);
            map.put(key , val);
        }else{
            map.put(key , val);
            newVal = val ;
        }
        trie.insert(key , newVal );
    }
    
    public int sum(String prefix) {
        int ans = trie.search(prefix);
        System.out.println("SUM = " + ans);
        return ans ;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */