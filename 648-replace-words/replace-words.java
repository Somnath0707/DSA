class Trie{

    static class Node{
        Node child[];
        int index ; // we'll know 
        boolean isEnd ; 

        public Node(){
            child = new Node[26];
            index = Integer.MAX_VALUE; 
            isEnd = false ;
        }
    }

    Node root; 

    Trie(){
        root = new Node ();
    }

    public void insert(String s , int index){
        Node node = root; 

        for(char ch : s.toCharArray()){
            int ind = ch - 'a';

            if(node.child[ind] == null){
                node.child[ind] = new Node();
            }

            node = node.child[ind];

            if(index < node.index)
            node.index = index; 
        }

        node.isEnd = true; 
    }

    public int search(String s ){
        Node node = root; 

        for(char ch : s.toCharArray()){
            int ind = ch - 'a';
            System.out.println(ch + " " + node.child[ind]);
            if(node.child[ind] == null){
                return -1 ; // keep the original word only 
            }
            node = node.child[ind];
            if(node.isEnd == true){
                System.out.println(node.index);
                return node.index;
            }
        }

        return - 1; 

    }
}
class Solution {
    public String replaceWords(List<String> list , String sentence) {
        // we only create one trie so which will do the job 

        Trie trie = new Trie();
        list.sort(Comparator.comparingInt(String::length));
        for(int i = 0 ; i < list.size() ; i++){
            trie.insert(list.get(i) , i);
        }

        StringBuilder str = new StringBuilder();

        String[] tempS = sentence.split(" ");

        for(String s : tempS){
            int search = trie.search(s);
            if(search == -1){
                str.append(s + " ");
            }
            else{
                str.append(list.get(search) + " ");
            }
        }

        return str.toString().trim();
    }
}