class Trie{

    static class Node{
        Node child[] ; 

        int minLen; 
        int minIndex; 
        boolean isEnd ;
        Node(){
            child = new Node[26];
            isEnd = false; 
            minLen = Integer.MAX_VALUE;
            minIndex = -1 ; 
        }
    }

    

    Node root; 
    Trie(){
        root = new Node(); 
    }

    public void insert(String s , int index ){
        // get the length 
        Node node = root;
        int len = s.length();

        if(root.minLen > len ){
            root.minLen = len; 
            root.minIndex = index; 
        }

        if(root.minLen == len && (root.minLen == -1 || root.minIndex > index)){
            root.minLen = len ; 
            root.minIndex = index; 
        }

        for(char ch : s.toCharArray()){
            int indx = ch -'a'; // the number of a b c to check in array 
            // if the character does not  exist currently we create a new node 
            if(node.child[indx] == null){
                node.child[indx] = new Node();
            }

            // we go to that child 
            node = node.child[indx] ;

            if(len < node.minLen ){
                node.minLen = len ; 
                node.minIndex = index;
            }

            // if len is same 
            else if(len == node.minLen && (node.minIndex == -1 || node.minIndex > index)){
                node.minIndex = index; 
            }
        }
        node.isEnd = true; 
    }

    public int search(String s){
        Node node = root ; 

        for(char ch : s.toCharArray()){
            int indx = ch-'a';
            if(node.child[indx] == null){
                return node.minIndex;
            }
            node = node.child[indx];
        }

        return node.minIndex;
    }
}



class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // we have to arrays 
        // wordsContainer and wordQuery
        // foreach wordQuery[i] we find word from container that has longest common suffix with wordsQuery[i];
        // we will need a trie for wordsContainer and then at each node we store the len and index for each index we match till we cant match we get the smallest length string index or the one which appear earlier 

        // Make a trie of wordsContainer 
        // Each node in trie much have as usual a array []
        // Best len till that as per question if same we have to get the smaller length word so best length 
        // And the index of the best length
        Trie trie = new Trie(); 
        int n = wordsContainer.length;
        for(int i = 0 ; i < n ; i++){

            StringBuilder s = new StringBuilder(wordsContainer[i]);


            trie.insert(s.reverse().toString(),i);
        }

        int ans[] = new int[wordsQuery.length];

        for(int i = 0 ; i < wordsQuery.length ; i++){
            StringBuilder s = new StringBuilder(wordsQuery[i]);
            ans[i] = trie.search(s.reverse().toString());
        }
        return ans;
    }
}