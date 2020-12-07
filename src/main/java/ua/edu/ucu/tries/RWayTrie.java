package ua.edu.ucu.tries;

import ua.edu.ucu.collections.Queue;

/**
 *
 * realized using book "Algorithms (4th Edition)"
 * by Robert Sedgewick, Kevin Wayne
 */
public class RWayTrie implements Trie {
    private static int R = 256; // radix
    private Node root = new Node(); // root of trie
    private int size = 0;
    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];


    }

    public RWayTrie(){
        this.root = null;
    }

    @Override
    public void add(Tuple t) {

        root = add(root, t.term, t.weight, 0);

        size ++;
    }

    public Node add(Node x, String key, int val, int d){

        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;return x;
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, val, d+1);

        return x;
    }

    public Node get(String key)
    {
        System.out.println(root.val);
        Node x = get(root, key, 0);
        return x;
    }
    private Node get(Node x, String key, int d)
    { // Return node associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }

    @Override
    public boolean contains(String word) {
        Node x = this.get(word);
        if(x != null){
            return true;
        }
        return false;
    }


    private Node delete(Node x, String key, int d)
    {
        if (x == null) return null;
        if (d == key.length())
            x.val = null;
        else
        {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }
    @Override
    public boolean delete(String word) {
        if (this.contains(word)){
            root = delete(root, word, 0);
            size --;
            return true;
        }
        return false;
    }

    @Override
    public Iterable<String> words() {
        return wordsWithPrefix("");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Queue q = new Queue();
        collect(get(s), s, q);
        return q;
    }

    private void collect(Node x, String pre,
                         Queue q)
    {
        if (x == null) {return;}
        if (x.val != null) {q.enqueue(pre);}
        for (char c = 0; c < R; c++){
            collect(x.next[c], pre + c, q);}
    }


    @Override
    public int size() {
        return this.size;
    }

}
