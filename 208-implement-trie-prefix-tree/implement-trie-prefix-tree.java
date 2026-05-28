class Trie {
    static class Node{
        Node child[] ;

        boolean isEnd; 

        Node(){
            child = new Node[26];
            isEnd = false; 
        }

    }

    Node root ;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int indx = ch - 'a';
            if(node.child[indx] == null){
                node.child[indx] = new Node();
            }

            node = node.child[indx];

        }

        node.isEnd = true; 
    }
    
    public boolean search(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){
            int indx = ch - 'a';
            System.out.println(ch + " " + node.child[indx]);
            if(node.child[indx] == null){
                return false; 
            }
            node = node.child[indx];
        }

        if(node.isEnd)
            return true; 
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(char ch : prefix.toCharArray()){
            int indx = ch - 'a';

            if(node.child[indx] == null){
                return false; 
            }

            node = node.child[indx];
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */