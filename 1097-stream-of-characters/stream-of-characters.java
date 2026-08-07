class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert a word
    public void insert(String s) {
        TrieNode curr = root;

        for (char ch : s.toCharArray()) {
            int indx = ch - 'a';

            if (curr.child[indx] == null) {
                curr.child[indx] = new TrieNode();
            }

            curr = curr.child[indx];
        }

        curr.isEnd = true;
    }

    // search complete word
    public boolean search(String s) {
        TrieNode curr = root;

        for (char ch : s.toCharArray()) {
            int indx = ch - 'a';

            if (curr.child[indx] == null)
                return false;

            curr = curr.child[indx];
        }

        return curr.isEnd;
    }

    // check prefix
    public boolean searchPrefix(String s) {
        TrieNode curr = root;

        for (char ch : s.toCharArray()) {
            int indx = ch - 'a';

            if (curr.child[indx] == null)
                return false;

            curr = curr.child[indx];
        }

        return true;
    }
}

class StreamChecker {

    Trie t;
    int max = 0;
    int min = Integer.MAX_VALUE;

    StringBuilder s = new StringBuilder();

    public StreamChecker(String[] words) {

        t = new Trie();

        int n = words.length;

        for (int i = 0; i < n; i++) {

            StringBuilder str = new StringBuilder(words[i]);

            min = Math.min(min, str.length());
            max = Math.max(max, str.length());

            t.insert(str.reverse().toString());
        }
    }

    public boolean query(char letter) {

        s.append(letter);

        int n = s.length();
        StringBuilder temp = new StringBuilder(); 
        for (int i = n - 1; i >= 0; i--) {
            temp.append(s.charAt(i));
            int len = n - i;

            if (len < min)
                continue;

            if (len > max)
                break;

            if(t.search(temp.toString()))
                return true;
        }

        return false;
    }
}